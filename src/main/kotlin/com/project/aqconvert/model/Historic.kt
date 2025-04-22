package com.project.aqconvert.model

import jakarta.persistence.*

@Entity
data class Historic(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "historic-generator")
    @TableGenerator(name = "historic-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
//    @OneToMany
//    val questao : Question,
    val respeRegistrada : Number,
    val acerto : Boolean,
    val qtdAcertos : Number,
    val qtdErros : Number,
//    @OneToMany
//    val tipoSimulado : Subject,
//    @OneToMany
//    val assunto : Topic,
//    @ManyToOne
//    val user : User,
    val tempoTotal : Number
)
