package ua.com.goit.gojava7.kikstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "qoutes")
public class Quote {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "seq_id", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private int id;

	@Column(name = "content")
	private String content;

	@Column(name = "author")
	private String author;

	public Quote() {
	}

	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String quoteContent) {
		this.content = quoteContent;
	}

	public void setAuthor(String quoteAuthor) {
		this.author = quoteAuthor;
	}

	public String toString() {
		return "ID: " + id + "; Content: " + content + "; Author: " + author;
	}

}
