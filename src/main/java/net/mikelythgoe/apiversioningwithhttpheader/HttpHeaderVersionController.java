package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpHeaderVersionController {

    @GetMapping(value = "/hello", version = "1") // version of "1", "1.0" or "1.0.0" will work, "1.1", "1.0.1", etc., will not work
    public String helloV1() {
        return "Hello Version One";
    }

    @GetMapping(value = "/hello", version = "9")
    public String helloV9() {
        return "Hello Version 9";
    }

    @GetMapping(value = "/hello", version = "9.9")
    public String helloV99() {
        return "Hello Version 9.9";
    }

// The method below fails - the app won't even start!!!
// The version MUST be major<.minor<.patch>> format where all parts, if used, are integers
//    @GetMapping(value = "/hello", version = "x.x")
//    public String helloVXx() {
//        return "Hello Version x.x";
//    }

}
