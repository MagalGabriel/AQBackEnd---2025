package com.project.aqconvert.service

import com.project.aqconvert.model.Question
import com.project.aqconvert.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(val questionRepository: QuestionRepository) {
    fun adicionar(question: Question){
        questionRepository.save( question )
    }

    fun procurarPorId(id : Long) : Question? {
        val questionOptional = questionRepository.findById( id )
        return questionOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val question = procurarPorId( id )
        return if (question != null) {
            questionRepository.delete(question)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Question>{
        return questionRepository.findAll()
    }

    fun atualizar(id : Long, novoquestion : Question) : Boolean {
        val encontrado = questionRepository.findById(id).isPresent
        if (encontrado) {
            novoquestion.id = id
            questionRepository.save(novoquestion)
        }
        return encontrado
    }
}