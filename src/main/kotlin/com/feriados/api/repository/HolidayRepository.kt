package com.feriados.api.repository

import com.feriados.api.model.Holiday
import org.springframework.data.repository.CrudRepository

interface HolidayRepository: CrudRepository<Holiday, Int> {
    fun findByIbgeCodeAndDate(ibgeCode: Int?, date: String): List<Holiday>

}
