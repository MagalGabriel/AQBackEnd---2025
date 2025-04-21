package com.project.aqconvert.controller

import com.project.aqconvert.model.Subject
import com.project.aqconvert.service.SubjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subject")
class SubjectController(val subjectService: SubjectService) {
    @GetMapping
    fun subjects(): ResponseEntity<List<Subject>> {
        return ResponseEntity.ok(subjectService.listarTodos())
    }

    @PostMapping
    fun criarSubject(@RequestBody subject: Subject): ResponseEntity<String> {
        subjectService.adicionar(subject)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarSubject(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = subjectService.apagar(id)
        if (apagado) {
            return ResponseEntity("Matéria com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarSubject(@PathVariable id: Long, @RequestBody novoSubject: Subject):
            ResponseEntity<String> {
        return if (subjectService.atualizar(id, novoSubject))
            ResponseEntity("Matéria atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}