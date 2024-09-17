package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.ClienteDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ClienteService
import tssti.fullstack.backend_kotlin_rest_api.view.ClienteView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/cliente")
class ClienteController(
    private val clienteService: ClienteService
)
{
   @GetMapping
   fun getAllClientes(): ResponseEntity<List<ClienteView>>{
       val cliestes: List<ClienteView> =
           this.clienteService.findAll().stream().map {
               cliente: Cliente -> ClienteView(cliente)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(cliestes)

   }

   @PostMapping
   fun salvarCliente(@RequestBody  dto: ClienteDTO): String {
       val objDTO = this.clienteService.save(dto.toEntity())
       return "*** POST: Novo Cliente ${objDTO.nome} salvo com sucesso!"
   }

    @GetMapping("/{id}")
    fun getClienteByID(@PathVariable id: Long): ClienteView{
        val objDTO : Cliente = this.clienteService.getByID(id)
        return ClienteView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deletarCliente(@PathVariable id: Long) = this.clienteService.delete(id)

}