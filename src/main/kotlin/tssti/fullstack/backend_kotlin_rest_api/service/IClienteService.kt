package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

interface IClienteService {

    fun salvarCliente(cliente: Cliente): Cliente
    fun findAllClientes(): List<Cliente>
    fun getClienteByID(clienteID: Long): Cliente
    fun deleteCliente(clienteID: Long)

}