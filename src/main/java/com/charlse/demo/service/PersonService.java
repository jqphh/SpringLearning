package com.charlse.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface PersonService {
    public String addMember(MultipartFile personImg, int personId, int personAge, String personName);

    public String delMember(String request);

    public String getMember(String request);

    public String getAllMember(String request);
}
