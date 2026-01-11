package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String API_VERSION_HEADER = "X-API-Version";
    private static final String[] SUPPORTED_VERSIONS = {"1.0", "2.0", "3.5", "9"};

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        // We use the built-in resolver for the header. 
        // By default, Spring 6.2 uses SemanticVersionParser, so no 'setStrategy' is needed.
        configurer
                .addSupportedVersions(SUPPORTED_VERSIONS)
                .setVersionRequired(true)
                .useRequestHeader(API_VERSION_HEADER);
    }
}