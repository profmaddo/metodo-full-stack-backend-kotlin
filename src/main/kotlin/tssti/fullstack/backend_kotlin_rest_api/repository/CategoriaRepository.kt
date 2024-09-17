package tssti.fullstack.backend_kotlin_rest_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria


@Repository
interface CategoriaRepository: JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM CATEGORIA", nativeQuery = true)
    fun getAll(): List<Categoria>

}