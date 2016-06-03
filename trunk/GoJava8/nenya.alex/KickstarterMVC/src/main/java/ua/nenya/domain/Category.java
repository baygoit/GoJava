package ua.nenya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Category.getCategories", query = "select c from Category c order by c.name"),
	@NamedQuery(name = "Category.getCategory", query = "select c from Category c where c.id=:categoryId"),
	@NamedQuery(name = "Category.Count", query = "select count(c) from Category c where c.id=:categoryId"),
	@NamedQuery(name = "Category.CountByName", query = "select count(c) from Category c where c.name=:categoryName")
	})
@Table(name = "CATEGORY")
public class Category{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
