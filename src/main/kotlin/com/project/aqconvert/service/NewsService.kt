package com.project.aqconvert.service

import com.project.aqconvert.model.News
import com.project.aqconvert.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(val newsRepository: NewsRepository) {
    fun adicionar(news: News){
        newsRepository.save( news )
    }

    fun procurarPorId(id : Long) : News? {
        val newsOptional = newsRepository.findById( id )
        return newsOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val news = procurarPorId( id )
        return if (news != null) {
            newsRepository.delete(news)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<News>{
        return newsRepository.findAll()
    }

    fun atualizar(id : Long, novonews : News) : Boolean {
        val encontrado = newsRepository.findById(id).isPresent
        if (encontrado) {
            novonews.id = id
            newsRepository.save(novonews)
        }
        return encontrado
    }
}