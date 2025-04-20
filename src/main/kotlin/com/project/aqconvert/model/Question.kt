package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator
import java.util.Objects

data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val enunciado : String,
    val pergunta : String,
    // pensar em como fazer o esquema de alternativas
    val lugarAno : String,
    //pensar como aplicar as variaveis de imagem
)
