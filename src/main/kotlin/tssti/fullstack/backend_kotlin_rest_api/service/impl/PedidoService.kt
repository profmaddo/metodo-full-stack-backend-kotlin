package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.repository.PedidoRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IPedidoService

@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository
): IPedidoService {
    override fun save(obj: Pedido): Pedido =
        this.pedidoRepository.save(obj)

    override fun findAll(): List<Pedido> {
        return this.pedidoRepository.findAll()
    }

    override fun getByID(id: Long): Pedido {
        return this.pedidoRepository.getReferenceById(id)
    }

    override fun delete(id: Long) {
        return this.pedidoRepository.deleteById(id)
    }
}