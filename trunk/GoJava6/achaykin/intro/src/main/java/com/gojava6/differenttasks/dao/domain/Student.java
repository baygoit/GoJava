package com.gojava6.differenttasks.dao.domain;

import java.util.Date;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public class Student {

    int id;
    String name;
    String surname;
    int group_id;
    Date enrolment_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public Date getEnrolment_date() {
        return enrolment_date;
    }

    public void setEnrolment_date(Date enrolment_date) {
        this.enrolment_date = enrolment_date;
    }
}
