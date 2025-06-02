package com.project.aqconvert.model.dtos

import jakarta.validation.constraints.Min

data class TopicDTO (
    var id : Long,
    val materia : String,
    val nome : String,
   // @field:Min(1)
    //val questionsId : Long
    )
