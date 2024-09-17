package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

data class CategoriaView(
    val categoriaID: Long?,
    val nome: String,
    val unidade: String
){
    constructor(categoria: Categoria): this(
        categoriaID = categoria.categoriaID,
        nome = categoria.nome,
        unidade = categoria.unidade
    )
}
