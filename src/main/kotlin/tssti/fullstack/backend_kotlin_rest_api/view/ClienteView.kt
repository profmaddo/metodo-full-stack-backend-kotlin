package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

data class ClienteView(
        val clienterID: Long?,
        val nome: String
){
    constructor(cliente: Cliente): this(
        clienterID = cliente.clienteID,
        nome = cliente.nome
    )
}
