package com.project.aqconvert.model

import jakarta.persistence.*

@Entity
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "image-generator")
    @TableGenerator(name = "image-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val nome : String,
    val img : String
)
