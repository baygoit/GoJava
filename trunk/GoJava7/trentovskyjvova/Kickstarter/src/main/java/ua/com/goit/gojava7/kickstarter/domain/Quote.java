package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "quote")
@NamedQueries({ @NamedQuery(name = "Quote.count", query = "select count(q) from Quote q"),
				@NamedQuery(name = "Quote.findAll", query = "select q from Quote q") })
public class Quote {
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
		setText(text);
		setAuthor(author);
	}

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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("text", text).append("author", author).toString();
	}
}
