package com.gojava2.kickstarter.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true, nullable = false, length = 15)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	public Role() {}
	
	@PersistenceConstructor
	public Role(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
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

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
}