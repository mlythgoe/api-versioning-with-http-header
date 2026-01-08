package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void configureApiVersioning(ApiVersionConfigurer configurer) {


        configurer
                .addSupportedVersions("1.0", "2.0", "3.5", "9") // Add Supported Versions defines what versions can be supplied
                .setDefaultVersion("2.0") // Used when no version, or an unsupported version, is passed in the request
                .useRequestHeader("X-API-Version"); // the name of the query parameter that supplies the version

    }
}
