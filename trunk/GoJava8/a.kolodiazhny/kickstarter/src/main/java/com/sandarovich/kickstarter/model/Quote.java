package com.sandarovich.kickstarter.model;

import javax.persistence.*;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

