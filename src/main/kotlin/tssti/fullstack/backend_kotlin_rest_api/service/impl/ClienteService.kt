package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.repository.ClienteRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IClienteService

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
): IClienteService {
    override fun save(cliente: Cliente): Cliente =
        this.clienteRepository.save(cliente)


    override fun findAll(): List<Cliente> {
        return this.clienteRepository.findAll()
    }

    override fun getByID(clienteID: Long): Cliente {
        return this.clienteRepository.getReferenceById(clienteID)
    }

    override fun delete(clienteID: Long) {
        return this.clienteRepository.deleteById(clienteID)
    }
}