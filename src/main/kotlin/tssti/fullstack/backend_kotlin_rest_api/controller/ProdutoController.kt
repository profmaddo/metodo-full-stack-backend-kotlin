package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.ProdutoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ProdutoService
import tssti.fullstack.backend_kotlin_rest_api.view.ProdutoView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/produto")
class ProdutoController(
    private val produtoService: ProdutoService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<ProdutoView>> {
        val lista: List<ProdutoView> =
            this.produtoService.findAll().stream().map { objDTO: Produto ->
                ProdutoView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)

    }

    @PostMapping
    fun save(@RequestBody dto: ProdutoDTO): String {
        val objDTO = this.produtoService.save(dto.toEntity())
        return "*** POST: Novo Produto ${objDTO.nome} salvo com sucesso!"
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ProdutoView {
        val objDTO: Produto = this.produtoService.getByID(id)
        return ProdutoView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.produtoService.delete(id)

}