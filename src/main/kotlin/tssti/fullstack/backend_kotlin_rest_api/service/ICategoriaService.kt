package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

interface ICategoriaService {

    fun save(categoria: Categoria): Categoria
    fun findAll(): List<Categoria>
    fun getByID(categoriaID: Long): Categoria
    fun delete(categoriaID: Long)

}