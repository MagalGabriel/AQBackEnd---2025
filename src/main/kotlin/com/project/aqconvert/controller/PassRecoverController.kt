package com.project.aqconvert.controller

import com.project.aqconvert.model.PassRecover
import com.project.aqconvert.service.PassRecoverService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/passrecover")
class PassRecoverController(val passRecoverService: PassRecoverService) {
    @GetMapping
    fun passRecovers(): ResponseEntity<List<PassRecover>> {
        return ResponseEntity.ok(passRecoverService.listarTodos())
    }

    @PostMapping
    fun criarPassRecover(@RequestBody passRecover: PassRecover): ResponseEntity<String> {
        passRecoverService.adicionar(passRecover)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarPassRecover(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = passRecoverService.apagar(id)
        if (apagado) {
            return ResponseEntity("pass recover com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarPassRecover(@PathVariable id: Long, @RequestBody novopassRecover: PassRecover):
            ResponseEntity<String> {
        return if (passRecoverService.atualizar(id, novopassRecover))
            ResponseEntity("pass recover atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}