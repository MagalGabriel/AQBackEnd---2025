package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator

data class PassRecover(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val user : User,
    val number : Number
)
