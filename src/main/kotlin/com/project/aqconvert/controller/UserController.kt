package com.project.aqconvert.controller

import com.project.aqconvert.model.User
import com.project.aqconvert.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @GetMapping
    fun users() : ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.listarTodos())
    }

    @PostMapping
    fun criarUsuario( @RequestBody user : User) : ResponseEntity<String> {
        userService.adicionar( user )
        return  ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarUsuario (@PathVariable id : Long) :ResponseEntity<String>{
        val apagado = userService.apagar( id )
        if (apagado){
            return ResponseEntity("Usuário com id: $id apagado com sucesso",HttpStatus.ACCEPTED)
        }else{
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

}