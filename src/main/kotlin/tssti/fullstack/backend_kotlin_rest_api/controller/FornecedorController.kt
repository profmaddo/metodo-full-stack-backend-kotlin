package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.FornecedorDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.service.impl.FornecedorService
import tssti.fullstack.backend_kotlin_rest_api.view.FornecedorView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/fornecedor")
class FornecedorController(
    private val service: FornecedorService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<FornecedorView>> {
        val lista: List<FornecedorView> =
            this.service.findAll().stream().map { objDTO: Fornecedor ->
                FornecedorView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)

    }

    @PostMapping
    fun save(@RequestBody dto: FornecedorDTO): ResponseEntity<String> {
        val objDTO = this.service.save(dto.toEntity())
        val mensagem = "*** POST: Novo Fornecedor ${objDTO.nome} salvo com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ResponseEntity<String> {
        val objDTO: Fornecedor = this.service.getByID(id)
        val message = "*** Fornecedor ${objDTO.nome} recuperado com sucesso!"
        return ResponseEntity.ok(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        this.service.delete(id)
        return ResponseEntity.noContent().build()
    }

}