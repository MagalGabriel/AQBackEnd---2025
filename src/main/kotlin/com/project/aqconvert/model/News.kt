package com.project.aqconvert.model

import jakarta.persistence.*

@Entity
data class News(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "news-generator")
    @TableGenerator(name = "news-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val titulo : String,
    val linkFonte : String,
    val linkImagem : String,
    val fonte : String,
    val resumo : String,
    val conteudo : String
)
