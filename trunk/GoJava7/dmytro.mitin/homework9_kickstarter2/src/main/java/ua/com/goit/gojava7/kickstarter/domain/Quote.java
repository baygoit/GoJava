package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.*;

@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "author")
    private String author;

    public Quote() {
    }

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
