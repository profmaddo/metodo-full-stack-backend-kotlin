package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Categoria(
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val categoriaID: Long? = null,
    @Column(nullable = false) val nome: String = "",
    @Column(nullable = false) val unidade: String = ""
)
