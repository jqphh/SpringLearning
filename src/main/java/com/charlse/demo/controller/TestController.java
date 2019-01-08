package com.charlse.demo.controller;

import com.charlse.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
//@RequestMapping(value = "/")
public class TestController {
    @Resource //装配bean
    private PersonService personService;

    @PostMapping("/addMem")
    @ResponseBody
    public String addMem(@RequestParam("personImg") MultipartFile perImg, @RequestParam("personId") int perId,
                         @RequestParam("personAge") int perAge, @RequestParam("personName") String perName) {
        return personService.addMember(perImg, perId, perAge, perName);
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
