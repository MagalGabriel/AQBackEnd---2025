package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator

data class Historic(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val questao : Question,
    val respeRegistrada : Number,
    val acerto : Boolean,
    val qtdAcertos : Number,
    val qtdErros : Number,
    val tipoSimulado : Subject,
    val assunto : Topic,
    val user : User,
    val tempoTotal : Number
)
