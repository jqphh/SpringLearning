package com.charlse.demo.service;

public interface PersonService {
    public String addMember(Integer perId, Integer age, String name);

    public String delMember(Integer perId);

    public String getMember(Integer perId);
}
