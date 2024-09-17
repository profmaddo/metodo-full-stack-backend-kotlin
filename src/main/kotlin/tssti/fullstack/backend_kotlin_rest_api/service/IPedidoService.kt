package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

interface IPedidoService {

    fun salvarPedido(pedido: Pedido): Pedido
    fun findAllPedidos(): List<Pedido>
    fun getPedidoByID(pedidoID: Long): Pedido
    fun deletePedido(pedidoID: Long)
    
}