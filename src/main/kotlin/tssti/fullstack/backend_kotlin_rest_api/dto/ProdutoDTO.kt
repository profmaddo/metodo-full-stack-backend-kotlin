package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.common.UnidadeMedida
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

data class ProdutoDTO(
    val produtoID: Long,
    val nome: String,
    val unidade: String,
    val categoriaID: Long,
    val fornecedorID: Long,
){
    fun toEntity(): Produto = Produto(
        produtoID = this.produtoID,
        nome = this.nome,
        unidade = UnidadeMedida.UNIDADE,
        categoria = Categoria(categoriaID = this.categoriaID),
        fornecedor = Fornecedor(fornecedorID = this.fornecedorID)
    )
}
