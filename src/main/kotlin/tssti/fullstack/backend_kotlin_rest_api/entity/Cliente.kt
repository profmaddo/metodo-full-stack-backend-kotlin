package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Cliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val clienteID: Long? = null,
    @Column(nullable = false) var nome: String = "",
    @Column(nullable = false) var email: String = "",
    @OneToMany(fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "cliente")
    var pedidos: List<Pedido> = mutableListOf(),
)
