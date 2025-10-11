package com.example.his.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("/test")
@RestController
public class Test {

    @PostMapping("/demo")
    public HashMap demo(String str) {
        System.out.println(str);
        return new HashMap() {{
            put("msg", "HelloWorld");
        }};
    }
}