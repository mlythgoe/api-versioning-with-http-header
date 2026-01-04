package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpHeaderVersionController {

    @GetMapping(value = "/hello", version = "1.0")
    public String helloV1() {
        return "Hello Version One";
    }

    @GetMapping(value = "/hello", version = "2.0")
    public String helloV2() {
        return "Hello Version Two";
    }

}
