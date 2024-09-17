package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.repository.FornecedorRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IFornecedorService

@Service
class FornecedorService(
    private val fornecedorRepository: FornecedorRepository
) : IFornecedorService {
    override fun save(obj: Fornecedor): Fornecedor =
        this.fornecedorRepository.save(obj)

    override fun findAll(): List<Fornecedor> {
        return this.fornecedorRepository.findAll()
    }

    override fun getByID(id: Long): Fornecedor {
        return this.fornecedorRepository.getReferenceById(id)
    }

    override fun delete(id: Long) {
        this.fornecedorRepository.deleteById(id)
    }
}