package com.project.aqconvert.model.dtos

import java.time.LocalDate

data class UserDTOView (
    var id : Long?,
    val nome : String,
    val nomeUsuario : String,
    val dataNasc : LocalDate,
    val email : String,
    val numCelular : String,
    val senha : String
)
