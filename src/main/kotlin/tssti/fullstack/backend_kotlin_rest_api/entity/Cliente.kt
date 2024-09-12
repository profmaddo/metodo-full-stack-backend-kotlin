package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Cliente (
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val clienteID: Long? = null,
    var nome: String = "",
    var email: String = ""
   // var listaDeObjetos: List<Object> = mutableListOf()
)