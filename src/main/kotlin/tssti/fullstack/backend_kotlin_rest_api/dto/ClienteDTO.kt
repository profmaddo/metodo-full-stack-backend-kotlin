package tssti.fullstack.backend_kotlin_rest_api.dto

data class ClienteDTO(
    val clienteID: Long,
    val nome: String,
    val email: String
){
    fun toEntity(): Cliente = Cliente(
        clienteID = this.clienteID,
        nome = this.nome,
        email = this.email,
    )

}
