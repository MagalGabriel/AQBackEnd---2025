package com.project.aqconvert.model

import jakarta.persistence.*

@Entity
data class PassRecover(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "passrecover-generator")
    @TableGenerator(name = "passrecover-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
//    @ManyToOne
//    val user : User,
    val number : Number
)
