package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

data class FornecedorView(
    val fornecedorID: Long?,
    val nome: String
){
    constructor(fornecedor: Fornecedor): this(
        fornecedorID = fornecedor.fornecedorID,
        nome = fornecedor.nome
    )
}
