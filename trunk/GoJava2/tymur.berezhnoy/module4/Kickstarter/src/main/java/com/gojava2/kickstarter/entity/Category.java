package com.gojava2.kickstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false, length = 250)
	private String name;
	
	public Category() {}
	
	@PersistenceConstructor
	public Category(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}