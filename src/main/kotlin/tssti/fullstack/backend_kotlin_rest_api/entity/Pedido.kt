package tssti.fullstack.backend_kotlin_rest_api.entity


import jakarta.persistence.*
import java.math.BigDecimal
import java.util.UUID

@Entity
data class Pedido(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pedidoID: Long? = null,
    val codigoPedido: UUID = UUID.randomUUID(),
    var quantidade: Int = 0,
    @Column(nullable = false) var preco: BigDecimal = BigDecimal.ZERO,
    @ManyToOne
    val cliente: Cliente? = null,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    var produto: Produto? = null,
)