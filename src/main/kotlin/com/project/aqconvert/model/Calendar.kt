package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator
import java.util.Date

data class Calendar(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val data : Date,
    val periodo : String,
    val linkReferencia : String
)
