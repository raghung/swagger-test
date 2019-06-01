package com.swagger

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.annotations.tags.Tag

@OpenAPIDefinition(
        info = @Info(
                title = "Swagger test",
                version = "0.1",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "http://swagger.mine"),
                contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        ),
        tags = [@Tag(
                 name = "Test",
                 description = "Test 1"
        )],
        servers = [@Server(
                    url = "http://localhost:1001",
                    description = "Local host"
                )]
)
@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.run(Application)
    }
}