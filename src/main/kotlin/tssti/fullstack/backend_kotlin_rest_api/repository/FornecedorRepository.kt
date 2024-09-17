package tssti.fullstack.backend_kotlin_rest_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

@Repository
interface FornecedorRepository: JpaRepository<Fornecedor, Long> {

    @Query(value = "SELECT * FROM FORNECEDOR", nativeQuery = true)
    fun getAll(): List<Fornecedor>

}