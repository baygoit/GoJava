package com.sandarovich.kickstarter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quote")
@NamedQueries({
    @NamedQuery(name = "Quote.getRandom", query = "SELECT q from Quote as q ORDER BY RAND()")
})
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

