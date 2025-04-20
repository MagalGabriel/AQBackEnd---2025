package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator

data class Image(

    val nome : String,
    val img : String
)
