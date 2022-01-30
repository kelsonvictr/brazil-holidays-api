package com.feriados.api.service

import com.feriados.api.enum.HolidayTypeEnum
import com.feriados.api.helper.HolidayHelper
import com.feriados.api.model.Holiday
import com.feriados.api.repository.HolidayRepository
import org.springframework.stereotype.Service

@Service
class HolidayService(
    val holidayRepository: HolidayRepository,
) {

    fun getAll(): List<Holiday> {
        return holidayRepository.findAll().toList()
    }

    fun create(request: Holiday) {
        if (request.ibgeCode == 0) {
            request.holidayType = HolidayTypeEnum.NACIONAL
        } else {
            request.holidayType = HolidayTypeEnum.LOCAL
        }
        holidayRepository.save(request)
    }

    fun manageNonFixedHolidays(codIbge: Int?, nome: String?) {
        val holidayHelper = HolidayHelper()
        val holiday = Holiday(null, nome, holidayHelper.getNonFixedHolidaysDates(nome).toString(), codIbge, HolidayTypeEnum.NACIONAL)
        holidayRepository.save(holiday)
    }

    fun getHoliday(ibgeCode: Int?, date: String): List<Holiday> {
        return holidayRepository.findByIbgeCodeAndDate(ibgeCode, date)
    }


}
