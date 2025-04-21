package com.project.aqconvert.controller

import com.project.aqconvert.model.News
import com.project.aqconvert.service.NewsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/news")
class NewsController(val newsService: NewsService) {
    @GetMapping
    fun news(): ResponseEntity<List<News>> {
        return ResponseEntity.ok(newsService.listarTodos())
    }

    @PostMapping
    fun criarNoticia(@RequestBody news: News): ResponseEntity<String> {
        newsService.adicionar(news)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarNoticia(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = newsService.apagar(id)
        if (apagado) {
            return ResponseEntity("Noticia com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarNoticia(@PathVariable id: Long, @RequestBody novoNews: News):
            ResponseEntity<String> {
        return if (newsService.atualizar(id, novoNews))
            ResponseEntity("Noticia atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}