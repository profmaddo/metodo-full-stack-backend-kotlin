package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

data class CategoriaDTO(
    val categoriaID: Long,
    val nome: String,
    val unidade: String
){
    fun toEntity(): Categoria = Categoria(
        categoriaID = this.categoriaID,
        unidade = this.unidade,
        nome = this.nome
    )
}
