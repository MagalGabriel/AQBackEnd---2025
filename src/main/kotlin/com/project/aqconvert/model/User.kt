package com.project.aqconvert.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator
import java.util.Date


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
    //val dataNasc : Date,
    val email : String,
    val numCelular : String,
    val senha : String,
    //pensar como aplicar as variaveis de imagem
)
