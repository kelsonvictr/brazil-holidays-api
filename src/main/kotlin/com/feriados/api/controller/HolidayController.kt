package com.feriados.api.controller

import com.feriados.api.enum.NonFixedHolidayEnum
import com.feriados.api.helper.HolidayHelper
import com.feriados.api.model.Holiday
import com.feriados.api.service.HolidayService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/feriados")
class HolidayController(
    val holidayService: HolidayService,
) {

    @GetMapping
    fun getAll(): List<Holiday> {
        return holidayService.getAll()
    }

    @PutMapping("/{codIbge}/{dateOrName}")
    fun create(@RequestBody request: Holiday?, @PathVariable codIbge: Int?, @PathVariable dateOrName: String) {
        val holidayHelper = HolidayHelper()
        if (NonFixedHolidayEnum.values().any { it.nome == dateOrName }) {
            holidayService.manageNonFixedHolidays(codIbge, dateOrName)
        } else {
            if (request != null) {
                request.ibgeCode = codIbge
                request.date = dateOrName
                holidayService.create(request)
            }

        }
    }

}