package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.repository.PedidoRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IPedidoService

@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository
): IPedidoService {
    override fun save(pedido: Pedido): Pedido =
        this.pedidoRepository.save(pedido)

    override fun findAll(): List<Pedido> {
        return this.pedidoRepository.findAll()
    }

    override fun getByID(pedidoID: Long): Pedido {
        return this.pedidoRepository.getReferenceById(pedidoID)
    }

    override fun delete(pedidoID: Long) {
        return this.pedidoRepository.deleteById(pedidoID)
    }
}