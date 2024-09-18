package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

interface IPedidoService {

    fun save(pedido: Pedido): Pedido
    fun findAll(): List<Pedido>
    fun getByID(pedidoID: Long): Pedido
    fun delete(pedidoID: Long)
    
}