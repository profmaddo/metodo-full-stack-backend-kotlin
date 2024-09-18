package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.CategoriaDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.service.impl.CategoriaService
import tssti.fullstack.backend_kotlin_rest_api.view.CategoriaView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/categoria")
class CategoriaController(
    private val categoriaService: CategoriaService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<CategoriaView>> {
        val lista: List<CategoriaView> =
            this.categoriaService.findAll().stream().map { objDTO: Categoria ->
                CategoriaView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)

    }

    @PostMapping
    fun save(@RequestBody dto: CategoriaDTO): ResponseEntity<String> {
        val objDTO = this.categoriaService.save(dto.toEntity())
        val mensagem = "*** POST: Nova Categoria  ${objDTO.nome} salva com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ResponseEntity<String> {
        val objDTO: Categoria = this.categoriaService.getByID(id)
        val message = "*** Categoria ${objDTO.nome} recuperada com sucesso!"
        return ResponseEntity.ok(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        this.categoriaService.delete(id)
        return ResponseEntity.noContent().build()
    }

}