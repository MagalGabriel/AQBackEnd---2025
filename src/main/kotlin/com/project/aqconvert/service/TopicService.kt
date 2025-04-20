package com.project.aqconvert.service

import com.project.aqconvert.model.Topic
import com.project.aqconvert.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(val topicRepository: TopicRepository) {
    fun adicionar(topic: Topic){
        topicRepository.save( topic )
    }

    fun procurarPorId(id : Long) : Topic? {
        val topicOptional = topicRepository.findById( id )
        return topicOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val topic = procurarPorId( id )
        return if (topic != null) {
            topicRepository.delete(topic)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Topic>{
        return topicRepository.findAll()
    }

    fun atualizar(id : Long, novotopic : Topic) : Boolean {
        val encontrado = topicRepository.findById(id).isPresent
        if (encontrado) {
            novotopic.id = id
            topicRepository.save(novotopic)
        }
        return encontrado
    }
}