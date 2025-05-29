package com.project.aqconvert.model.dtos

import jakarta.validation.constraints.NotEmpty



data class SubjectDTO (
    var id : Long,
    @field:NotEmpty
    val materiaPertence : String,
    val nome : String,

)
