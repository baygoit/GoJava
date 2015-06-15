package com.morkva.entities;

import com.morkva.model.dao.Identified;

/**
 * Created by vladyslav on 30.04.15.
 */
public class Quote implements Identified<Integer> {

    private Integer id;
    private String value;
    private String author;

    public Quote(int id, String value, String author) {
        this.value = value;
        this.author = author;
    }

    public Quote() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"" + " (" + author + ")";
    }

    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
}
