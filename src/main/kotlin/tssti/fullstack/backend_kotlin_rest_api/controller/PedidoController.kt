package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.PedidoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.service.impl.PedidoService
import tssti.fullstack.backend_kotlin_rest_api.view.PedidoView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/pedido")
class PedidoController(
    private val service: PedidoService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<PedidoView>> {
        val lista: List<PedidoView> =
            this.service.findAll().stream().map { objDTO: Pedido ->
                PedidoView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)

    }

    @PostMapping
    fun save(@RequestBody dto: PedidoDTO): ResponseEntity<String> {
        val objDTO = this.service.save(dto.toEntity())
        val mensagem = "*** POST: Novo Pedido ${objDTO.cliente?.nome} salvo com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ResponseEntity<String> {
        val objDTO: Pedido = this.service.getByID(id)
        val message = "*** Pedido ${objDTO.cliente?.nome} ${objDTO.produto?.nome} recuperado com sucesso!"
        return ResponseEntity.ok(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        this.service.delete(id)
        return ResponseEntity.noContent().build()
    }


}