package com.project.aqconvert.service

import com.project.aqconvert.model.Calendar
import com.project.aqconvert.repository.CalendarRepository
import org.springframework.stereotype.Service

@Service
class CalendarService(val calendarRepository: CalendarRepository) {
    fun adicionar(calendar: Calendar){
        calendarRepository.save( calendar )
    }

    fun procurarPorId(id : Long) : Calendar? {
        val calendarOptional = calendarRepository.findById( id )
        return calendarOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val calendar = procurarPorId( id )
        return if (calendar != null) {
            calendarRepository.delete(calendar)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Calendar>{
        return calendarRepository.findAll()
    }

    fun atualizar(id : Long, novocalendar : Calendar) : Boolean {
        val encontrado = calendarRepository.findById(id).isPresent
        if (encontrado) {
            novocalendar.id = id
            calendarRepository.save(novocalendar)
        }
        return encontrado
    }
}