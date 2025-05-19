package com.project.aqconvert.model.dtos

import java.sql.Date

data class UserDTOView (
    var id : Long?,
    val nome : String,
    val nomeUsuario : String,
    val dataNasc : Date,
    val email : String,
    val numCelular : String,
    val senha : String,
)
