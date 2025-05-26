package com.project.aqconvert.model.dtos

import jakarta.validation.constraints.Min

data class TopicDTO (
    var id : Long,
    @field:Min(1)
    val materiaId : Long,
    val nome : String,
    @field:Min(1)
    val questionsId : Long
    )
