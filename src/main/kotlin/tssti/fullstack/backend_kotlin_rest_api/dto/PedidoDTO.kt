package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import java.util.UUID

data class PedidoDTO(
    val pedidoID: Long,
    val codigoPedido: UUID,
){
    fun toEntity(): Pedido = Pedido(
        id = this.pedidoID,
        codigoPedido = this.codigoPedido
    )
}
