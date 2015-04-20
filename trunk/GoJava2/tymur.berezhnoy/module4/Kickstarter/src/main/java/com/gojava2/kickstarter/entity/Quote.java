package com.gojava2.kickstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "quotes")
public class Quote {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false, length = 250)
	private String content;
	
	@Column(length = 30)
	private String author;
	
	@Transient
	private final char COPIRIGHT_SYMBOL = 169;
	
	public Quote() {}
	
	@PersistenceConstructor
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public char getCopyrightSymbol() {
		return COPIRIGHT_SYMBOL;
	}
}