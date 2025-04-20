package com.project.aqconvert.service

import com.project.aqconvert.model.Subject
import com.project.aqconvert.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService(val subjectRepository: SubjectRepository) {
    fun adicionar(subject: Subject){
        subjectRepository.save( subject )
    }

    fun procurarPorId(id : Long) : Subject? {
        val subjectOptional = subjectRepository.findById( id )
        return subjectOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val subject = procurarPorId( id )
        return if (subject != null) {
            subjectRepository.delete(subject)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Subject>{
        return subjectRepository.findAll()
    }

    fun atualizar(id : Long, novosubject : Subject) : Boolean {
        val encontrado = subjectRepository.findById(id).isPresent
        if (encontrado) {
            novosubject.id = id
            subjectRepository.save(novosubject)
        }
        return encontrado
    }
}