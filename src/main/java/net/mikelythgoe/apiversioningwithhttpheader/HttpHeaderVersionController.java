package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpHeaderVersionController {
    // For versioning, the version must be major.minor.patch format

    // http://localhost:8080/hello http header X-API-Version=1.0 (you can use 1.0, 1, or 1.0.0, but you can't use 1.1, 1.0.1, etc.)
    @GetMapping(value = "/hello", version = "1")
    public String helloV1() {
        return """
                {
                    "message":"Hello Version 1"
                }
                """;
    }

    // http://localhost:8080/hello http header X-API-Version=2.0 (you can use 2.0, 2, or 2.0.0, but you can't use 2.1, 2.0.1, etc.)
    // Example: curl --location 'http://localhost:8080/hello' --header 'X-Api-Version: 2.0'
    @GetMapping(value = "/hello", version = "2.0")
    public String helloV2point0() {
        return """
                {
                    "message":"Hello Version 2"
                }
                """;
    }

    // http://localhost:8080/hello, http header X-API-Version=3.5 (you can use 3.5, or 3.5.0, but you can't use 3, 3.6., 3.5.1, etc.)
    @GetMapping(value = "/hello", version = "3.5")
    public String helloV3point5() {
        return """
                {
                    "message":"Hello Version 3.5"
                }
                """;
    }

    // http://localhost:8080/hello http header X-API-Version=9 (you can use 9, 9.0, or 9.0.0, but you can't use 9.1, 9.0.1, etc.)
    @GetMapping(value = "/hello", version = "9")
    public String helloV9() {
        return """
                {
                    "message":"Hello Version 9"
                }
                """;
    }

    // http://localhost:8080/hello http header X-API-Version=9.9 (you can use 9.9, or 9.9.0, but you can't use 9.1, 9.9.1, etc.)
    @GetMapping(value = "/hello", version = "9.9")
    public String helloV9point9() {
        return """
                {
                    "message":"Hello Version 9.9"
                }
                """;
    }

    // http://localhost:8080/hello http header X-API-Version=9.9.9 (you can use 9.9.9, or 9.9.9.0, but you can't use 9.9.1, 9.9.9.1, etc.)
    @GetMapping(value = "/hello", version = "9.9.9")
    public String helloV9point9point9() {
        return """
                {
                    "message":"Hello Version 9.9.9"
                }
                """;
    }

    // The method below fails - the app won't even start!!!
// The version MUST be in major<.minor<.patch>> format where all parts, if used, are integers
//    @GetMapping(value = "/hello", version = "x.x")
//    public String helloVXx() {
//        return "Hello Version x.x";
//    }

}
