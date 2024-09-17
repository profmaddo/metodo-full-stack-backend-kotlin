package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

interface IFornecedorService {

    fun save(fornecedor: Fornecedor): Fornecedor
    fun findAll(): List<Fornecedor>
    fun getByID(fornecedorID: Long): Fornecedor
    fun delete(fornecedorID: Long)

}