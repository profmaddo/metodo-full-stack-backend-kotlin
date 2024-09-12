package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

data class ProdutoDTO(
    val produtoID: Long,
    val nome: String,
){
    fun toEntity(): Produto = Produto(
        id = this.produtoID,
        nome = this.nome
    )
}
