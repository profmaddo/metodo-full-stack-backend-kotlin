package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Fornecedor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val fornecedorID: Long? = null,
    @Column(nullable = false) val nome: String  = "",
    @Column(nullable = false) val contato: String = "",
    @Column(nullable = false) val email: String = "",
    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "fornecedor")
    var produtos: List<Produto> = emptyList()
)
