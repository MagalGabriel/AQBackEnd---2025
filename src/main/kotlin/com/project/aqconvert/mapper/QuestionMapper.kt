package com.project.aqconvert.mapper

import com.project.aqconvert.model.Question
import com.project.aqconvert.model.dtos.QuestionDTO
import com.project.aqconvert.model.dtos.QuestionDTOView
import org.springframework.stereotype.Component

@Component
class QuestionMapper {

    fun toDTO(question: Question) : QuestionDTOView {
        return QuestionDTOView(
            id = question.id,
            enunciado = question.enunciado,
            pergunta = question.pergunta

        )


    }

    fun fromDTO(questionDTO: QuestionDTO) : Question? {
        return Question(
            id = questionDTO.id,
            enunciado = questionDTO.enunciado,
            pergunta = questionDTO.pergunta
        )
    }

}