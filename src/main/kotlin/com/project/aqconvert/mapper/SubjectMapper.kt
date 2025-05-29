package com.project.aqconvert.mapper

import com.project.aqconvert.model.Subject
import com.project.aqconvert.model.dtos.SubjectDTO
import com.project.aqconvert.model.dtos.SubjectDTOView
import org.springframework.stereotype.Component

@Component
class SubjectMapper {

    fun toDTO(subject: Subject) : SubjectDTOView {
        return SubjectDTOView(
            id = subject.id,
            materiaPertence = subject.materiaPertence,
            nome = subject.nome,

        )


    }

    fun fromDTO(subjectDTO: SubjectDTO) : Subject? {
        return Subject(
            id = subjectDTO.id,
            materiaPertence = subjectDTO.materiaPertence,
            nome = subjectDTO.nome,

        )
    }

}