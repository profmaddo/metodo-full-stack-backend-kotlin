package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.CategoriaDTO
import tssti.fullstack.backend_kotlin_rest_api.dto.ProdutoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ProdutoService
import tssti.fullstack.backend_kotlin_rest_api.view.ProdutoView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/produto")
class ProdutoController(
    private val produtoService: ProdutoService
)
{
   @GetMapping
   fun getAllProdutos(): ResponseEntity<List<ProdutoView>>{
       val produtos: List<ProdutoView> =
           this.produtoService.findAllProdutos().stream().map {
               produto: Produto -> ProdutoView(produto)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(produtos)

   }

   @PostMapping
   fun salvarProduto(@RequestBody  dto: ProdutoDTO): String {
       val objDTO = this.produtoService.salvarProduto(dto.toEntity())
       return "*** POST: Novo Produto ${objDTO.nome} salvo com sucesso!"
   }

    @GetMapping("/{id}")
    fun getProdutoByID(@PathVariable id: Long): ProdutoView{
        val objDTO : Produto = this.produtoService.getProdutoByID(id)
        return ProdutoView(objDTO)
    }

    //@DeleteMapping
    @DeleteMapping("/{id}")
    fun deletarProduto(@PathVariable id: Long) = this.produtoService.deleteProduto(id)


}