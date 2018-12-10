package com.charlse.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.charlse.demo.dao.PersonDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class PersonHandle implements PersonService {
    @Resource //装配bean
    public PersonDao personDao;

    public String addMember(String request) {
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        Integer age = ((JSONObject) json).getInteger("age");
        String name = ((JSONObject) json).getString("name");

        try {
            PersonInfo pInfo = personDao.getPerson(id);
            if(null != pInfo) {
                return "{\"code\":\"Already exists\"}";
            } else {
                PersonInfo person = new PersonInfo();
                person.setPerId(id);
                person.setAge(age);
                person.setName(name);
                personDao.addPerson(person);
            }
        } catch(SQLException e) {
            return "{\"code\":\"error\"}";
        }
        return "{\"code\":\"success\"}";
    }

    public String delMember(String request) {
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        try {
            PersonInfo pInfo = personDao.getPerson(id);
            if(null == pInfo) {
                return "{\"code\":\"Ele not exists\"}";
            } else {
                personDao.delPerson(id);
            }
        } catch(SQLException e) {
            return "{\"code\":\"error\"}";
        }
        return "{\"code\":\"success\"}";
    }

    public String getMember(String request) {
        JSON json = JSON.parseObject(request);
        Integer id = ((JSONObject) json).getInteger("perId");
        try {
            PersonInfo pInfo = personDao.getPerson(id);
            if(null == pInfo) {
                return "{\"code\":\"Ele not exists\"}";
            } else {
                JSONObject rspJson = new JSONObject();
                rspJson.put("code", "1000");
                rspJson.put("perId", pInfo.getPerId());
                rspJson.put("age", pInfo.getAge());
                rspJson.put("name", pInfo.getName());
                return rspJson.toJSONString();
            }
        } catch(SQLException e) {
            return "{\"code\":\"error\"}";
        }
    }

    public String getAllMember(String request) {
        try {
            ArrayList<PersonInfo> pInfoList = personDao.getAllPerson();
            if(null == pInfoList) {
                return "{\"code\":\"Ele not exists\"}";
            } else {
                JSONObject rspJson = new JSONObject();
                rspJson.put("code", "1000");
                rspJson.put("list", pInfoList);
                return rspJson.toJSONString();
            }
        } catch (SQLException e) {
            return "{\"code\":\"error\"}";
        }
    }
}
