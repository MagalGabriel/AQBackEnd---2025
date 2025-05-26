package com.project.aqconvert.model.dtos

import com.project.aqconvert.model.Question
import com.project.aqconvert.model.Subject


data class TopicDTOView (
    var id : Long?,
    var materia : Subject,
    var nome : String,
    var questions : Question

    )
