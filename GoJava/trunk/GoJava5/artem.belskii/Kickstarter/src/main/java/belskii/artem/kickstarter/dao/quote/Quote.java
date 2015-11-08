package belskii.artem.kickstarter.dao.quote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table (name="QUOTE")
public class Quote {
	@Id
	@Column (name="ID")
	private int id;
	
	@Column (name="QUOTE", length=500)
	private String quote;
	
	Quote(){
	}
	Quote(int id, String text){
		this.setId(id);
		this.setQuote(text);
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
}
