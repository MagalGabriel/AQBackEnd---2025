package com.project.aqconvert.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user-generator")
    @TableGenerator(name = "user-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val nome : String,
    val nomeUsuario : String,
    @Column(columnDefinition = "DATE")
    val dataNasc : LocalDate,
    val email : String,
    val numCelular : String,
    val senha : String
    //pensar como aplicar as variaveis de imagem
)
