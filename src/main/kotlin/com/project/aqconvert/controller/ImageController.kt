package com.project.aqconvert.controller

import com.project.aqconvert.model.Image
import com.project.aqconvert.service.ImageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/image")
class ImageController(val imageService: ImageService) {
    @GetMapping
    fun images(): ResponseEntity<List<Image>> {
        return ResponseEntity.ok(imageService.listarTodos())
    }

    @PostMapping
    fun criarImagem(@RequestBody image: Image): ResponseEntity<String> {
        imageService.adicionar(image)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarImagem(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = imageService.apagar(id)
        if (apagado) {
            return ResponseEntity("Imagem com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarImagem(@PathVariable id: Long, @RequestBody novoImage: Image):
            ResponseEntity<String> {
        return if (imageService.atualizar(id, novoImage))
            ResponseEntity("Imagem atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}