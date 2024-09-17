package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

data class ProdutoView(
    val produtoID: Long?,
    val nome: String
){
    constructor(produto: Produto): this(
        produtoID = produto.produtoID,
        nome = produto.nome
    )
}
