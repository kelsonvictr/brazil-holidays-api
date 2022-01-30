package com.feriados.api.model

import com.feriados.api.enum.HolidayTypeEnum
import javax.persistence.*

@Entity
data class Holiday (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String? = null,

    @Column
    var date: String? = null,

    @Column
    var ibgeCode: Int? = null,

    @Column
    @Enumerated(EnumType.STRING)
    var holidayType: HolidayTypeEnum? = null

    ){

}


