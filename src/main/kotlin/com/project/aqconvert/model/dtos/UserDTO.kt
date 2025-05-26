package com.project.aqconvert.model.dtos

import jakarta.validation.constraints.NotEmpty
import java.sql.Date



data class UserDTO (
    var id : Long,
    @field:NotEmpty
    val nome : String,
    val nomeUsuario : String,
    val dataNasc : Date,
    val email : String,
    val numCelular : String,
    val senha : String,
)
