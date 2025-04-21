package com.project.aqconvert.controller

import com.project.aqconvert.model.Historic
import com.project.aqconvert.service.HistoricService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/historic")
class HistoricController(val historicService: HistoricService) {
    @GetMapping
    fun historics(): ResponseEntity<List<Historic>> {
        return ResponseEntity.ok(historicService.listarTodos())
    }

    @PostMapping
    fun criarHistorico(@RequestBody historic: Historic): ResponseEntity<String> {
        historicService.adicionar(historic)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarHistorico(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = historicService.apagar(id)
        if (apagado) {
            return ResponseEntity("Histórico com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarHistorico(@PathVariable id: Long, @RequestBody novoHistoric: Historic):
            ResponseEntity<String> {
        return if (historicService.atualizar(id, novoHistoric))
            ResponseEntity("Histórico atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}