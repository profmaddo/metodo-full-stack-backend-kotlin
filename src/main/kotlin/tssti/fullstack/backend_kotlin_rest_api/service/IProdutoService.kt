package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

interface IProdutoService {

    fun salvarProduto(produto: Produto): Produto
    fun findAllProdutos(): List<Produto>
    fun getProdutoByID(produtoID: Long): Produto
    fun deleteProduto(produtoID: Long)

}