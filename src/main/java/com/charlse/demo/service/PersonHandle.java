package com.charlse.demo.service;

import com.charlse.demo.dao.PersonDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PersonHandle implements PersonService {
    @Resource //装配bean
    public PersonDao personDao;

    public String addMember(Integer perId, Integer age, String name) {
        if(null != name) {
            //personDao.addPerson(perId, age, name);
        }
        return "{\"code\":\"1000\"}";
    }

    public String delMember(Integer perId) {
        return "{\"code\":\"1000\"}";
    }

    public String getMember(Integer perId) {
        return "{\"code\":\"1000\"}";
    }
}
