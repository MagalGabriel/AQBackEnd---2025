package com.project.aqconvert.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.TableGenerator

@Entity
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "topic-generator")
    @TableGenerator(name = "topic-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    //@ManyToOne
    val materia : String,
    val nome : String,
    //@OneToMany
    //val questions : Question,
    //pensar como aplicar as variaveis de imagem


)
//TÓPICO OU ASSUNTO