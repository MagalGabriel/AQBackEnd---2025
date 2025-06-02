package com.project.aqconvert.model

import jakarta.persistence.*


@Entity
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "subject-generator")
    @TableGenerator(name = "subject-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val materiaPertence : String,
    val nome : String,
    //pensar como aplicar as variaveis de imagem
)
//MATÉRIA






