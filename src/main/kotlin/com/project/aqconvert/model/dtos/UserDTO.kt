package com.project.aqconvert.model.dtos

import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate


data class UserDTO (
    var id : Long,
    @field:NotEmpty(message = "O nome não pode ser vazio")
    val nome : String,
    val nomeUsuario : String,
    val dataNasc : LocalDate,
    val email : String,
    val numCelular : String,
    val senha : String
)
