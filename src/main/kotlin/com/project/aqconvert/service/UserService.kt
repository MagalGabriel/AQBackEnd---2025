package com.project.aqconvert.service

import com.project.aqconvert.model.User
import com.project.aqconvert.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository) {

    fun adicionar(user: User){
        userRepository.save( user )
    }

    fun procurarPorId(id : Long) : User? {
        val userOptional = userRepository.findById( id )
        return userOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val user = procurarPorId( id )
        return if (user != null) {
            userRepository.delete(user)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<User>{
        return userRepository.findAll()
    }

}