package com.project.aqconvert.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.TableGenerator
import java.util.Objects

data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val pertence : Array<String> = arrayOf( "Ciências da Natureza", "Ciências Humanas",
        "Matemática", "Linguagens"),
    val nome : String,
    //pensar como aplicar as variaveis de imagem
)



{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Subject

        return pertence.contentEquals(other.pertence)
    }

    override fun hashCode(): Int {
        return pertence.contentHashCode()
    }
}
