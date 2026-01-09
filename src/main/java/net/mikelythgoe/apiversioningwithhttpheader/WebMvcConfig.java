package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String API_VERSION_HEADER = "X-API-Version";
    private static final String DEFAULT_VERSION = "2.0";
    private static final String[] SUPPORTED_VERSIONS = {"1.0", "2.0", "3.5", "9"};

    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer
                .addSupportedVersions(SUPPORTED_VERSIONS)
                .setDefaultVersion(DEFAULT_VERSION)
                .useRequestHeader(API_VERSION_HEADER);
    }
}