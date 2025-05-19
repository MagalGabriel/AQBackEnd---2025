package com.project.aqconvert.mapper

import com.project.aqconvert.model.dtos.UserDTOView
import com.project.aqconvert.model.User
import com.project.aqconvert.model.dtos.UserDTO
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toDTO(user: User) : UserDTOView {
        return UserDTOView(
            id = user.id,
            nome = user.nome,
            nomeUsuario = user.nomeUsuario,
            dataNasc = user.dataNasc,
            email = user.email,
            senha = user.senha,
            numCelular = user.numCelular
        )


    }

    fun fromDTO(userDTO: UserDTO) : User? {
        return User(
            id = userDTO.id,
            nome = userDTO.nome,
            nomeUsuario = userDTO.nomeUsuario,
            dataNasc = userDTO.dataNasc,
            email = userDTO.email,
            senha = userDTO.senha,
            numCelular = userDTO.numCelular
        )
    }

}