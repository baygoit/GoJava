package com.anmertrix.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@NamedQueries({ 
	@NamedQuery(name = "Category.getCategories", query = "SELECT c from Category c"),
	@NamedQuery(name = "Category.count", query = "SELECT COUNT(c) FROM Category c where c.id=:categoryId"),
	@NamedQuery(name = "Category.getCategory", query = "SELECT c from Category c where c.id=:categoryId")
})
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
