package goit.nz.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CATEGORIES")
public class Category {

	@Column(name = "NAME", unique = true)
	private String name;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	public Category() {};
	
	public Category(long id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

}
