package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Categoria(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoriaID: Long? = null,
    @Column(nullable = false) val nome: String = "",
    // enum
    @Column(nullable = false) val unidade: String = "",
)
