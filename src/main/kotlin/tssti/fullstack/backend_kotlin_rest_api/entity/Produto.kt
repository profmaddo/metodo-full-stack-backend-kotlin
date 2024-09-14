package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import tssti.fullstack.backend_kotlin_rest_api.common.UnidadeMedida

@Entity
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val produtoID: Long? = null,
    val nome: String = "",
    val unidade: UnidadeMedida = UnidadeMedida.UNIDADE,
    val categoria: Categoria? = null,
    val fornecedor: List<Fornecedor> = emptyList()
)
