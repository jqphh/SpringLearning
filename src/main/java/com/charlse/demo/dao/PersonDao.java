package com.charlse.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;

public interface PersonDao {
    /**
     * 存储记录到person表
     *
     * @param perId
     * @param age
     * @param name
     * @throws SQLException
     */
    void addPerson(@Param("perId") Integer perId, @Param("age") Integer age, @Param("name") String name);

    /**
     * 从person表删除记录
     *
     * @param perId
     * @throws SQLException
     */
    void delPerson(@Param("perId") Integer perId);

}