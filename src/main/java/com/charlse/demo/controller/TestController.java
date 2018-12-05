package com.charlse.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.charlse.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Resource //装配bean
    private PersonService personService;

    @PostMapping("/addMem")
    public String addMem(@RequestBody String request) {
        System.out.println(request);
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        Integer age = ((JSONObject) json).getInteger("age");
        String name = ((JSONObject) json).getString("name");
        return personService.addMember(id, age, name);
    }

    @PostMapping("/delMem")
    public String delMem(@RequestBody String request) {
        System.out.println(request);
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        System.out.println(id);
        return personService.delMember(id);
    }
}
