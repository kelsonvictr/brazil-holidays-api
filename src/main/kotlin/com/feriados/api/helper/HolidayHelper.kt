package com.feriados.api.helper

import com.feriados.api.enum.NonFixedHolidayEnum
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter

class HolidayHelper {

    fun getNonFixedHolidaysDates(holiday: String?): LocalDate? {
        val getHolidayDate = when (holiday) {
            NonFixedHolidayEnum.CARNAVAL.nome -> getEasterSundayDate(Year.now().getValue())?.minusDays(47)
            NonFixedHolidayEnum.CORPUSCHRISTI.nome -> getEasterSundayDate(Year.now().getValue())?.plusDays(60)
            NonFixedHolidayEnum.SEXTASANTA.nome -> getEasterSundayDate(Year.now().getValue())?.minusDays(2)
            else -> null
        }

        return getHolidayDate
    }

    private fun getEasterSundayDate(year: Int): LocalDate? {
        val a = year % 19
        val b = year / 100
        val c = year % 100
        val d = b / 4
        val e = b % 4
        val g = (8 * b + 13) / 25
        val h = (19 * a + b - d - g + 15) % 30
        val j = c / 4
        val k = c % 4
        val m = (a + 11 * h) / 319
        val r = (2 * e + 2 * j - k - h + m + 32) % 7
        val n = (h - m + r + 90) / 25
        val p = (h - m + r + n + 19) % 32
        var mes: String = n.toString()
        if (n.toString().length == 1) {
            mes = "0$n"
        }
        val dateString: String = Year.now().value.toString() + "-" + mes + "-" + p

        return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE)
    }

}