package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.repository.ProdutoRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IProdutoService

@Service
class ProdutoService(
    private val produtoRepository: ProdutoRepository
) : IProdutoService {
    override fun salvarProduto(produto: Produto): Produto =
        this.produtoRepository.save(produto)

    override fun findAllProdutos(): List<Produto> {
        return this.produtoRepository.findAll()
    }

    override fun getProdutoByID(produtoID: Long): Produto {
        return this.produtoRepository.getReferenceById(produtoID)
    }

    override fun deleteProduto(produtoID: Long) {
        return this.produtoRepository.deleteById(produtoID)
    }
}