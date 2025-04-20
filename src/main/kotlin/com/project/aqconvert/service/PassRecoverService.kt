package com.project.aqconvert.service

import com.project.aqconvert.model.PassRecover
import com.project.aqconvert.repository.PassRecoverRepository
import org.springframework.stereotype.Service

@Service
class PassRecoverService(val passRecoverRepository: PassRecoverRepository) {
    fun adicionar(passRecover: PassRecover){
        passRecoverRepository.save( passRecover )
    }

    fun procurarPorId(id : Long) : PassRecover? {
        val passRecoverOptional = passRecoverRepository.findById( id )
        return passRecoverOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val passRecover = procurarPorId( id )
        return if (passRecover != null) {
            passRecoverRepository.delete(passRecover)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<PassRecover>{
        return passRecoverRepository.findAll()
    }

    fun atualizar(id : Long, novopassRecover : PassRecover) : Boolean {
        val encontrado = passRecoverRepository.findById(id).isPresent
        if (encontrado) {
            novopassRecover.id = id
            passRecoverRepository.save(novopassRecover)
        }
        return encontrado
    }
}