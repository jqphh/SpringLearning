package com.charlse.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @GetMapping("/index")
    public String index(){
        System.out.println("Begin");
        return "测试1111111111111111111111";
    }

    @PostMapping("/test1")
    public String test1(@RequestBody String request) {
        System.out.println(request);
        return "{aa}";
    }
}
