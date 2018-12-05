package com.charlse.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.charlse.demo.dao.PersonDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PersonHandle implements PersonService {
    @Resource //装配bean
    public PersonDao personDao;

    public String addMember(String request) {
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        Integer age = ((JSONObject) json).getInteger("age");
        String name = ((JSONObject) json).getString("name");

        //personDao.addPerson(id, age, name);
        return "{\"code\":\"1000\"}";
    }

    public String delMember(String request) {
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        //personDao.delPerson(id);
        return "{\"code\":\"1000\"}";
    }

    public String getMember(String request) {
        return "{\"code\":\"1000\"}";
    }
}
