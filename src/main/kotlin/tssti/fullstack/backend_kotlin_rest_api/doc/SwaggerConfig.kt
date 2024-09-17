package tssti.fullstack.backend_kotlin_rest_api.doc

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean

/**
 * Swagger Documentação da API
 */
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Rest API - Full Stack")
                    .version("1.0")
                    .version("www.tssti.com.br")
                    .description("API REST Sprint Boot Kotlin")
            )
    }
}