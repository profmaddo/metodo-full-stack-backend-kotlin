package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.CategoriaDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.service.impl.CategoriaService
import tssti.fullstack.backend_kotlin_rest_api.view.CategoriaView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/categoria")
class CategoriaController(
    private val categoriaService: CategoriaService
)
{
   @GetMapping
   fun getAllCategorias(): ResponseEntity<List<CategoriaView>>{
       val clietes: List<CategoriaView> =
           this.categoriaService.findAllCategorias().stream().map {
               categoria: Categoria -> CategoriaView(categoria)
           }.collect(Collectors.toList())
       return ResponseEntity.status(HttpStatus.OK).body(clietes)

   }

   @PostMapping
   fun salvarCategoria(@RequestBody  dto: CategoriaDTO): String {
       val objDTO = this.categoriaService.salvarCategoria(dto.toEntity())
       return "*** POST: Nova Categoria ${objDTO.nome} salva com sucesso!"
   }

    @GetMapping("/{id}")
    fun getCategoriaByID(@PathVariable id: Long): CategoriaView{
        val objDTO : Categoria = this.categoriaService.getCategoriaByID(id)
        return CategoriaView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deletarCategoria(@PathVariable id: Long) = this.categoriaService.deleteCategoria(id)

}