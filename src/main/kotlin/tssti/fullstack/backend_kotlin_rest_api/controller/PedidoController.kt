package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.PedidoDTO
import tssti.fullstack.backend_kotlin_rest_api.dto.ProdutoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.service.impl.PedidoService
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ProdutoService
import tssti.fullstack.backend_kotlin_rest_api.view.PedidoView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/pedido")
class PedidoController(
    private val pedidoService: PedidoService
)
{
   @GetMapping
   fun getAllPedidos(): ResponseEntity<List<PedidoView>>{
       val pedidos: List<PedidoView> =
           this.pedidoService.findAllPedidos().stream().map {
               pedido: Pedido -> PedidoView(pedido)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(pedidos)

   }

   @PostMapping
   fun salvarPedido(@RequestBody  dto: PedidoDTO): String {
       val objDTO = this.pedidoService.salvarPedido(dto.toEntity())
       return "*** POST: Novo Pedido Produto ${objDTO.produto?.nome} salvo com sucesso!"
   }

    @GetMapping("/{id}")
    fun getPedidoByID(@PathVariable id: Long): PedidoView{
        val objDTO : Pedido = this.pedidoService.getPedidoByID(id)
        return PedidoView(objDTO)
    }

    //@DeleteMapping
    @DeleteMapping("/{id}")
    fun deletarPedido(@PathVariable id: Long) = this.pedidoService.deletePedido(id)


}