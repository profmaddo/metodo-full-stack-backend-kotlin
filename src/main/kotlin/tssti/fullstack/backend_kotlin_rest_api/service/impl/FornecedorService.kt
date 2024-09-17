package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.repository.FornecedorRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IFornecedorService

@Service
class FornecedorService(
    private val fornecedorRepository: FornecedorRepository
) : IFornecedorService {
    override fun salvarFornecedor(fornecedor: Fornecedor): Fornecedor =
        this.fornecedorRepository.save(fornecedor)

    override fun findAllFornecedores(): List<Fornecedor> {
        return this.fornecedorRepository.findAll()
    }

    override fun getFornecedoreByID(fornecedorID: Long): Fornecedor {
        return this.fornecedorRepository.getReferenceById(fornecedorID)
    }

    override fun deleteFornecedor(fornecedorID: Long) {
        this.fornecedorRepository.deleteById(fornecedorID)
    }
}