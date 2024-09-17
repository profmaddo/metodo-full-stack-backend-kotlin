package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/rodando")
class Controller {

    @GetMapping
    fun rodando(): String {
        return "<h1>Rodando....</h1>"
    }
}