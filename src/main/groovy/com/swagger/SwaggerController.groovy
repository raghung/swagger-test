package com.swagger

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import io.swagger.v3.oas.annotations.Hidden

import javax.inject.Inject

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
}
