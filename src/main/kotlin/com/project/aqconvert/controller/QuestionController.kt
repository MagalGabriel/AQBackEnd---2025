package com.project.aqconvert.controller

import com.project.aqconvert.model.Question
import com.project.aqconvert.service.QuestionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/question")
class QuestionController(val questionService: QuestionService) {
    @GetMapping
    fun questions(): ResponseEntity<List<Question>> {
        return ResponseEntity.ok(questionService.listarTodos())
    }

    @PostMapping
    fun criarQuestao(@RequestBody question: Question): ResponseEntity<String> {
        questionService.adicionar(question)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarQuestao(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = questionService.apagar(id)
        if (apagado) {
            return ResponseEntity("Questão com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarQuestao(@PathVariable id: Long, @RequestBody novoQuestion: Question):
            ResponseEntity<String> {
        return if (questionService.atualizar(id, novoQuestion))
            ResponseEntity("Questão atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}