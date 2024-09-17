package tssti.fullstack.backend_kotlin_rest_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

@Repository
interface PedidoRepository: JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM PEDIDO", nativeQuery = true)
    fun getAll(): List<Pedido>
}