package com.charlse.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.charlse.demo.dao.PersonDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class PersonHandle implements PersonService {
    @Resource //装配bean
    public PersonDao personDao;

    public String addMember(MultipartFile personImg, int personId, int personAge, String personName) {
        if(personImg.isEmpty()) {
            return "{\"code\":\"empty file\"}";
        }

        String fileName = personImg.getOriginalFilename();
        int fileSize = (int) personImg.getSize();

        System.out.println("filename->" + fileName + ", fileSize->" + fileSize);
        String path = "E:";
        File dest = new File(path + "/" + "sprint.jpg");

        try {
            personImg.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"code\":\"failed\"}";
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
