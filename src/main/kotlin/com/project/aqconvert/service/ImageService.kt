package com.project.aqconvert.service

import com.project.aqconvert.model.Image
import com.project.aqconvert.repository.ImageRepository
import org.springframework.stereotype.Service

@Service
class ImageService(val imageRepository: ImageRepository) {
    fun adicionar(image: Image){
        imageRepository.save( image )
    }

    fun procurarPorId(id : Long) : Image? {
        val imageOptional = imageRepository.findById( id )
        return imageOptional.orElse( null )
    }

    fun apagar(id : Long) : Boolean{
        val image = procurarPorId( id )
        return if (image != null) {
            imageRepository.delete(image)
            true
        }else{
            false
        }
    }

    fun listarTodos() :List<Image>{
        return imageRepository.findAll()
    }

    fun atualizar(id : Long, novoimage : Image) : Boolean {
        val encontrado = imageRepository.findById(id).isPresent
        if (encontrado) {
            novoimage.id = id
            imageRepository.save(novoimage)
        }
        return encontrado
    }
}