package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.util.UUID

@Entity
data class Pedido(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pedidoID: Long? = null,
    val codigoPedido: UUID = UUID.randomUUID(),
    val quantidade: Int = 0,
    @Column(nullable = false) val preco: BigDecimal = BigDecimal.ZERO,
    @ManyToOne val cliente: Cliente? = null,
    @ManyToOne val produto: Produto? = null,
)
