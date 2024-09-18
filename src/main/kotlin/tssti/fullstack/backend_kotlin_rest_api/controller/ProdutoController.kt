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
    private val service: ProdutoService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<ProdutoView>> {
        val lista: List<ProdutoView> =
            this.service.findAll().stream().map { objDTO: Produto ->
                ProdutoView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)

    }

    @PostMapping
    fun save(@RequestBody dto: ProdutoDTO): ResponseEntity<String> {
        val objDTO = this.service.save(dto.toEntity())
        val mensagem = "*** POST: Novo Produto ${objDTO.nome} salvo com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ResponseEntity<String> {
        val objDTO: Produto = this.service.getByID(id)
        val message = "*** Produto ${objDTO.nome} recuperado com sucesso!"
        return ResponseEntity.ok(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        this.service.delete(id)
        return ResponseEntity.noContent().build()
    }

}