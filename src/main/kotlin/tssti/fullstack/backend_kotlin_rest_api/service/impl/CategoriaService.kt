package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.repository.CategoriaRepository
import tssti.fullstack.backend_kotlin_rest_api.service.ICategoriaService

@Service
class CategoriaService(
    private val categoriaRepository: CategoriaRepository
): ICategoriaService{
    override fun salvarCategoria(categoria: Categoria): Categoria =
        this.categoriaRepository.save(categoria)

    override fun findAllCategorias(): List<Categoria> {
        return this.categoriaRepository.findAll()
    }

    override fun getCategoriaByID(categoriaID: Long): Categoria {
        return this.categoriaRepository.getReferenceById(categoriaID)
    }

    override fun deleteCategoria(categoriaID: Long) {
        return this.categoriaRepository.deleteById(categoriaID)
    }


}