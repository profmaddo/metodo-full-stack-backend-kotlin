package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

interface IClienteService {

    fun save(cliente: Cliente): Cliente
    fun findAll(): List<Cliente>
    fun getByID(clienteID: Long): Cliente
    fun delete(clienteID: Long)

}