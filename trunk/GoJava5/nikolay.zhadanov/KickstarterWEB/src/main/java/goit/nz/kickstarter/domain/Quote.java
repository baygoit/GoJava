package goit.nz.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "quotes")
public class Quote {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "text")
	private String text;
	@Column(name = "author")
	private String author;

	public Quote() {};
	
	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public Quote(String text) {
		this.text = text;
		this.author = "Unknown";
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
