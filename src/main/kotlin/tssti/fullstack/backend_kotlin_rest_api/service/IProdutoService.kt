package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

interface IProdutoService {

    fun save(produto: Produto): Produto
    fun findAll(): List<Produto>
    fun getByID(produtoID: Long): Produto
    fun delete(produtoID: Long)

}