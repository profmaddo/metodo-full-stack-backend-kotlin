package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.CategoriaDTO
import tssti.fullstack.backend_kotlin_rest_api.dto.FornecedorDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.service.impl.FornecedorService
import tssti.fullstack.backend_kotlin_rest_api.view.CategoriaView
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
       val fornecedores: List<FornecedorView> =
           this.fornecedorService.findAllFornecedores().stream().map {
               fornecedor: Fornecedor -> FornecedorView(fornecedor)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(fornecedores)

   }

   @PostMapping
   fun salvarFornecedor(@RequestBody  dto: FornecedorDTO): String {
       val objDTO = this.fornecedorService.salvarFornecedor(dto.toEntity())
       return "*** POST: Novo Fornecedor ${objDTO.nome} salvo com sucesso!"
   }

    @GetMapping("/{id}")
    fun getFornecedorByID(@PathVariable id: Long): FornecedorView{
        val objDTO : Fornecedor = this.fornecedorService.getFornecedoreByID(id)
        return FornecedorView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deletarCategoria(@PathVariable id: Long) = this.fornecedorService.deleteFornecedor(id)

}