package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.repository.ClienteRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IClienteService

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
): IClienteService {
    override fun save(obj: Cliente): Cliente =
        this.clienteRepository.save(obj)


    override fun findAll(): List<Cliente> {
        return this.clienteRepository.findAll()
    }

    override fun getByID(id: Long): Cliente {
        return this.clienteRepository.getReferenceById(id)
    }

    override fun delete(id: Long) {
        return this.clienteRepository.deleteById(id)
    }
}