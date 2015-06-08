package com.morkva.entities;

/**
 * Created by vladyslav on 30.04.15.
 */
public class Quote extends Entity{

    private String value;
    private String author;

    public Quote(int id, String value, String author) {
        super(id);
        this.value = value;
        this.author = author;
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
}
