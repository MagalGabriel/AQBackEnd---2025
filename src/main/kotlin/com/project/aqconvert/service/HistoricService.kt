package com.project.aqconvert.service

import com.project.aqconvert.model.Historic
import com.project.aqconvert.repository.HistoricRepository
import org.springframework.stereotype.Service


@Service
class HistoricService(val historicRepository: HistoricRepository) {
    fun adicionar(historic: Historic){
        historicRepository.save( historic )
    }

    fun procurarPorId(id : Long) : Historic? {
        val historicOptional = historicRepository.findById( id )
        return historicOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val historic = procurarPorId( id )
        return if (historic != null) {
            historicRepository.delete(historic)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Historic>{
        return historicRepository.findAll()
    }

    fun atualizar(id : Long, novohistoric : Historic) : Boolean {
        val encontrado = historicRepository.findById(id).isPresent
        if (encontrado) {
            novohistoric.id = id
            historicRepository.save(novohistoric)
        }
        return encontrado
    }
}