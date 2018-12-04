package com.charlse.demo.service;

import java.sql.SQLException;

public interface PersonDao {
    /**
     * 存储记录到person表
     *
     * @param message
     * @throws SQLException
     */
    void addPerson(@Param("perId") Integer perId, @Param("age") Integer age, @Param("name") String name);

    /**
     * 从person表删除记录
     *
     * @param message
     * @throws SQLException
     */
    void delPerson(@Param("perId") Integer perId);

}
