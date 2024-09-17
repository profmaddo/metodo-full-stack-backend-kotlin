package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

interface ICategoriaService {

    fun salvarCategoria(categoria: Categoria): Categoria
    fun findAllCategorias(): List<Categoria>
    fun getCategoriaByID(categoriaID: Long): Categoria
    fun deleteCategoria(categoriaID: Long)

}