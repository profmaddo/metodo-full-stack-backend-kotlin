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
    private val fornecedorService: FornecedorService
)
{
   @GetMapping
   fun getAllFornecedores(): ResponseEntity<List<FornecedorView>>{
       val lista: List<FornecedorView> =
           this.fornecedorService.findAll().stream().map {
               objDTO: Fornecedor -> FornecedorView(objDTO)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(lista)

   }

   @PostMapping
   fun salvarFornecedor(@RequestBody  dto: FornecedorDTO): String {
       val objDTO = this.fornecedorService.save(dto.toEntity())
       return "*** POST: Novo Fornecedor ${objDTO.nome} salvo com sucesso!"
   }

    @GetMapping("/{id}")
    fun getFornecedorByID(@PathVariable id: Long): FornecedorView{
        val objDTO : Fornecedor = this.fornecedorService.getByID(id)
        return FornecedorView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deletarCategoria(@PathVariable id: Long) = this.fornecedorService.delete(id)

}