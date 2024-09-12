package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

data class FornecedorDTO(
    val fornecedorID: Long,
    val nome: String,
){
    fun toEntity(): Fornecedor = Fornecedor(
        fornecedorID = this.fornecedorID,
        nome = this.nome
    )
}
