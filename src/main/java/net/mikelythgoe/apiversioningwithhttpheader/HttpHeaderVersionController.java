package net.mikelythgoe.apiversioningwithhttpheader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpHeaderVersionController {

    @GetMapping(value = "/hello", version = "1.0")
    public String helloV1() {
        return "Hello Version One";
    }


    @GetMapping(value = "/hello", version = "9.9")
    public String helloV99() {
        return "Hello Version 9.9";
    }

// The methods below fails - the app won't even start - the version must be major.minor<.patch> numbers
//    @GetMapping(value = "/hello", version = "x.x")
//    public String helloVXx() {
//        return "Hello Version x.x";
//    }

}
