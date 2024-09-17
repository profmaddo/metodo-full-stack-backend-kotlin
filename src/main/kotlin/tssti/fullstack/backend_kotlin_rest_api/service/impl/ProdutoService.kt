package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.repository.ProdutoRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IProdutoService

@Service
class ProdutoService(
    private val produtoRepository: ProdutoRepository
) : IProdutoService {
    override fun save(obj: Produto): Produto =
        this.produtoRepository.save(obj)

    override fun findAll(): List<Produto> {
        return this.produtoRepository.findAll()
    }

    override fun getByID(id: Long): Produto {
        return this.produtoRepository.getReferenceById(id)
    }

    override fun delete(id: Long) {
        return this.produtoRepository.deleteById(id)
    }
}