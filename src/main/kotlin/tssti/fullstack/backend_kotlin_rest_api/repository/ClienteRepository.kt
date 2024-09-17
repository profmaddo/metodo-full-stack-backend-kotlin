package tssti.fullstack.backend_kotlin_rest_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente


@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    fun getAll(): List<Cliente>

}