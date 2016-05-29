package kickstarter.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "comments")
@Table(name = "comments")
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "number")
	private int number;

	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "author")
	private String author;

	@Column(name = "text")
	private String text;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
