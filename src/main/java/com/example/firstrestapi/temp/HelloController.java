package com.example.firstrestapi.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hi")
    public String hello(){
        return "Hello Developer!";
    }
}
