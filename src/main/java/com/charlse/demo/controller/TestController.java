package com.charlse.demo.controller;

import com.charlse.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
//@RequestMapping(value = "/")
public class TestController {
    @Resource //装配bean
    private PersonService personService;

    /*@GetMapping("/index")
    public String index(@RequestBody String request) {
        return "/static/index.html";
    }*/

    @PostMapping("/addMem")
    public String addMem(@RequestBody String request) {
        System.out.println(request);
        return personService.addMember(request);
    }

    @PostMapping("/delMem")
    public String delMem(@RequestBody String request) {
        return personService.delMember(request);
    }

    @PostMapping("/getMem")
    public String getMem(@RequestBody String request) {
        return personService.getMember(request);
    }

    @PostMapping("/getAllMem")
    public String getAllMem(@RequestBody String request) {
        return personService.getAllMember(request);
    }
}
