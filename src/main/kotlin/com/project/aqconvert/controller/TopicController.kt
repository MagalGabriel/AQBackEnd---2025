package com.project.aqconvert.controller

import com.project.aqconvert.model.Topic
import com.project.aqconvert.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
class TopicController(val topicService: TopicService) {

    @GetMapping
    fun topics(): ResponseEntity<List<Topic>> {
        return ResponseEntity.ok(topicService.listarTodos())
    }

    @PostMapping
    fun criarTopic(@RequestBody topic: Topic): ResponseEntity<String> {
        topicService.adicionar(topic)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarTopic(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = topicService.apagar(id)
        if (apagado) {
            return ResponseEntity("Tópico com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarTopic(@PathVariable id: Long, @RequestBody novoTopic: Topic):
            ResponseEntity<String> {
        return if (topicService.atualizar(id, novoTopic))
            ResponseEntity("Tópico atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }

}