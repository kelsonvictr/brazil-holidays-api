package com.feriados.api.repository

import com.feriados.api.model.Holiday
import org.springframework.data.repository.CrudRepository

interface HolidayRepository: CrudRepository<Holiday, Int> {

}
