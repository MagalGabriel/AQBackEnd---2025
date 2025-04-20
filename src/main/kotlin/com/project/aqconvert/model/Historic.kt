package com.project.aqconvert.model

data class Historic(
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
