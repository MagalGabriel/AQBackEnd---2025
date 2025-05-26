package com.project.aqconvert.mapper

import com.project.aqconvert.model.Topic
import com.project.aqconvert.model.dtos.TopicDTO
import com.project.aqconvert.model.dtos.TopicDTOView
import com.project.aqconvert.service.QuestionService
import com.project.aqconvert.service.SubjectService
import org.springframework.stereotype.Component

@Component
class TopicMapper(
    val subjectService : SubjectService,
    val questionService: QuestionService
) {

    fun toDTO(topic: Topic) : TopicDTOView {
        return TopicDTOView(
            id = topic.id,
            materia = topic.materia,
            nome = topic.nome,
            questions = topic.questions
        )


    }

    fun fromDTO(topicDTO: TopicDTO) : Topic? {
        val subject = subjectService.procurarPorId(topicDTO.materiaId)
        val questions = questionService.procurarPorId(topicDTO.questionsId)
        if (subject != null && questions != null) {
            return Topic(
                id = topicDTO.id,
                materia = subject,
                nome = topicDTO.nome,
                questions = questions

            )
        }else{
            return null
        }
    }

}