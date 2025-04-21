package com.project.aqconvert.controller

import com.project.aqconvert.model.Calendar
import com.project.aqconvert.service.CalendarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/calendar")
class CalendarController(val calendarService : CalendarService) {
    @GetMapping
    fun calendars(): ResponseEntity<List<Calendar>> {
        return ResponseEntity.ok(calendarService.listarTodos())
    }

    @PostMapping
    fun criarCalendario(@RequestBody calendar: Calendar): ResponseEntity<String> {
        calendarService.adicionar(calendar)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarCalendario(@PathVariable id: Long): ResponseEntity<String> {
        val apagado = calendarService.apagar(id)
        if (apagado) {
            return ResponseEntity("Calendário com id: $id apagado com sucesso", HttpStatus.ACCEPTED)
        } else {
            return ResponseEntity("Id $id não foi encontrado", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun atualizarCalendario(@PathVariable id: Long, @RequestBody novoCalendar: Calendar):
            ResponseEntity<String> {
        return if (calendarService.atualizar(id, novoCalendar))
            ResponseEntity("Calendário atualizado com sucesso", HttpStatus.OK)
        else {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        }
    }
}