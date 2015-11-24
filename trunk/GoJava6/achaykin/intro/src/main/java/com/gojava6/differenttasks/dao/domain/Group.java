package com.gojava6.differenttasks.dao.domain;

import org.omg.PortableInterceptor.ServerRequestInfo;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public class Group {

    int id;
    int number;
    String department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
