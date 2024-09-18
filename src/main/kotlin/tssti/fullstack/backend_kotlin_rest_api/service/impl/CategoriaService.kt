package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.repository.CategoriaRepository
import tssti.fullstack.backend_kotlin_rest_api.service.ICategoriaService

@Service
class CategoriaService(
    private val categoriaRepository: CategoriaRepository
): ICategoriaService{
    override fun save(obj: Categoria): Categoria =
        this.categoriaRepository.save(obj)

    override fun findAll(): List<Categoria> {
        return this.categoriaRepository.findAll()
    }

    override fun getByID(id: Long): Categoria {
        return this.categoriaRepository.getReferenceById(id)
    }

    override fun delete(id: Long) {
        return this.categoriaRepository.deleteById(id)
    }


}