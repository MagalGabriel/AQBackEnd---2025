package com.project.aqconvert.model

import jakarta.persistence.*

@Entity
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "question-generator")
    @TableGenerator(name = "question-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val enunciado : String,
    val pergunta : String,
    // pensar em como fazer o esquema de alternativas
    //val lugarAno : String,
    //pensar como aplicar as variaveis de imagem
)
