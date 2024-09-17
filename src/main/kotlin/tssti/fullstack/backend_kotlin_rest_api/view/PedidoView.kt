package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

data class PedidoView(
    val pedidoID: Long?,
    val nomeClinte: String,
    val nomeProduto: String
){
    constructor(pedido: Pedido): this(
        pedidoID = pedido.pedidoID,
        nomeClinte = pedido.cliente?.nome.toString(),
        nomeProduto = pedido.produto?.nome.toString()
    )
}
