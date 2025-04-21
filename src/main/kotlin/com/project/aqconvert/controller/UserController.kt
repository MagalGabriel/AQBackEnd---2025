package com.project.aqconvert.controller

import com.project.aqconvert.model.User
import com.project.aqconvert.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @GetMapping
    fun users(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.listarTodos())
    }

    @PostMapping
    fun criarUsuario(@RequestBody user: User): ResponseEntity<String> {
        userService.adicionar(user)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarUsuario(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = userService.apagar(id)
        if (apagado) {
            return ResponseEntity("Usuário com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarUsuario(@PathVariable id: Long, @RequestBody novoUser: User):
            ResponseEntity<String> {
        return if (userService.atualizar(id, novoUser))
            ResponseEntity("Usuário atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }

}