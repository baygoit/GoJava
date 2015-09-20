package ua.com.goit.gojava.alexfurman.kickstarter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {

	@Id
	@GeneratedValue
	private Integer id;

	private String quote;

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuote() {
		return quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
