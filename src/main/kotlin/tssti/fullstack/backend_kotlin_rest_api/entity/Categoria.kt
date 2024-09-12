package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Categoria(
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String = "",
    val unidade: String = ""
)