package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.repository.FornecedorRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IFornecedorService

@Service
class FornecedorService(
    private val fornecedorRepository: FornecedorRepository
) : IFornecedorService {
    override fun save(fornecedor: Fornecedor): Fornecedor =
        this.fornecedorRepository.save(fornecedor)

    override fun findAll(): List<Fornecedor> {
        return this.fornecedorRepository.findAll()
    }

    override fun getByID(fornecedorID: Long): Fornecedor {
        return this.fornecedorRepository.getReferenceById(fornecedorID)
    }

    override fun delete(fornecedorID: Long) {
        this.fornecedorRepository.deleteById(fornecedorID)
    }
}