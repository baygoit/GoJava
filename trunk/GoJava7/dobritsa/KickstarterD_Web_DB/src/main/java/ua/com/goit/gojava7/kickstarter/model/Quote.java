package ua.com.goit.gojava7.kickstarter.model;

import javax.persistence.*;

@Entity
@Table(name = "quote")
@NamedQueries({ @NamedQuery(name = "Quote.count", query = "select count(q) as cnt from Quote q"),
		@NamedQuery(name = "Quote.findAll", query = "select q from Quote q") })
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long quoteId;
	@Column
	private String text;
	@Column
	private String author;		

	public Long getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
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
		return "Quote [quoteId=" + quoteId + ", text=" + text + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (quoteId ^ (quoteId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (this.quoteId != null & other.quoteId != null) {
			if (this.quoteId != other.quoteId) {
				return false;
			}
		}

		if (this.text != null & other.text != null) {
			if (this.text != other.text) {
				return false;
			}
		}
		return true;
	}
}
