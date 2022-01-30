package com.feriados.api

import com.feriados.api.enum.NonFixedHolidayEnum

fun main() {

    print(NonFixedHolidayEnum.values().any { it.nome.equals("t-u") })
}
