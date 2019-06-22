package com.swagger

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties(SwaggerConfig.PREFIX)
@CompileStatic
class SwaggerConfig {
    static final String PREFIX = "application.api.swagger"

    String version
    String layout
    boolean deepLinking
    List<URIConfig> urls

    @ConfigurationProperties(URIConfig.PREFIX)
    static class URIConfig {

        static final String PREFIX = "urls"

        String name
        String url
    }
}
