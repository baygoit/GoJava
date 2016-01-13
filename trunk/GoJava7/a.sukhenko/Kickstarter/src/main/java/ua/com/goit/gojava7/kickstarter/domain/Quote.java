package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;


import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="quotes")
public class Quote{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
    private String text;
	@Column
    private String author;

    public Quote() {

    }

    public Quote(String text, String author) {
        super();
        this.text = text;
        this.author = author;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
