package com.swagger

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.views.View
import io.swagger.v3.oas.annotations.Hidden

import javax.inject.Inject
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Hidden
@Controller('/api')
class SwaggerController {

    @Inject
    SwaggerConfig swaggerConfig

    @View("swagger/index")
    @Get
    SwaggerConfig index() {
        return swaggerConfig
    }

    @View("swagger/index")
    @Get("/{url}")
    public SwaggerConfig renderSpec(@NotNull String url) {
        SwaggerConfig config = new SwaggerConfig()
        config.deepLinking = swaggerConfig.deepLinking
        config.layout = swaggerConfig.layout
        config.version = swaggerConfig.version
        config.urls = singletonList(new SwaggerConfig.URIConfig(name: url, url: url))

        return config
    }

    @View("swagger/index")
    @Post
    public SwaggerConfig renderSpecs(@Body @NotEmpty List<SwaggerConfig.URIConfig> urls) {

        SwaggerConfig config = new SwaggerConfig()
        config.deepLinking = swaggerConfig.deepLinking
        config.layout = swaggerConfig.layout
        config.version = swaggerConfig.version
        config.urls = urls

        return config
    }
}
