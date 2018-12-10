package com.charlse.demo.dao;

import com.charlse.demo.service.PersonInfo;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDao {

    void addPerson(PersonInfo person);

    void delPerson(@Param("perId") Integer perId) throws SQLException;

    PersonInfo getPerson(@Param("perId") Integer perId) throws SQLException;

    ArrayList<PersonInfo> getAllPerson() throws SQLException;
}
