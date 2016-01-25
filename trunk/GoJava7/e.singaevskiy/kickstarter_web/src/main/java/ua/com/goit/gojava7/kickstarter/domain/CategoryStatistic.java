package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryStatistic {
	@Id
	private Long id;
	private String name;
	private Long sum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}
	
	@Override
	public String toString() {
		return "CategoryStatistic [id=" + id + ", name=" + name + ", sum=" + sum + "]";
	}
}