package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

interface IFornecedorService {

    fun salvarFornecedor(fornecedor: Fornecedor): Fornecedor
    fun findAllFornecedores(): List<Fornecedor>
    fun getFornecedoreByID(fornecedorID: Long): Fornecedor
    fun deleteFornecedor(fornecedorID: Long)

}