package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*
import tssti.fullstack.backend_kotlin_rest_api.common.UnidadeMedida

@Entity
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val produtoID: Long? = null,
    @Column(nullable = false) val nome: String = "",
    @Enumerated val unidade: UnidadeMedida = UnidadeMedida.UNIDADE,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var categoria: Categoria? = null,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var fornecedor: Fornecedor? = null
)
