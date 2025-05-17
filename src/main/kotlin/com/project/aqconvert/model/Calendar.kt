package com.project.aqconvert.model

import jakarta.persistence.*
import java.util.Date

@Entity
data class Calendar(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "calendar-generator")
    @TableGenerator(name = "calendar-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    //val data : Date,
    val periodo : String,
    val linkReferencia : String
)
