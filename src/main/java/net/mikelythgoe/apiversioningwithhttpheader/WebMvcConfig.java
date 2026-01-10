package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String API_VERSION_HEADER = "X-API-Version";
    private static final String[] SUPPORTED_VERSIONS = {"1.0", "2.0", "3.5", "9"};

    public void configureApiVersioning(ApiVersionConfigurer configurer) {

        // In this project, we set 'Version Required' to true,
        // meaning the version MUST be passed, and there is no default, so the default version has been removed
        // from the configuration.
        configurer
                .addSupportedVersions(SUPPORTED_VERSIONS)
                .setVersionRequired(true)
                .useRequestHeader(API_VERSION_HEADER);
    }
}