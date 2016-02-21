package com.kickstarter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
/*@NamedQueries({ @NamedQuery(name = "Quote.count", query = "select count(q) as cnt from Quote q"),
		@NamedQuery(name = "Quote.findAll", query = "select q from Quote q") })*/
public class Quote {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String quote;
	private String author;

	public Quote() {
	}

	public Quote(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
