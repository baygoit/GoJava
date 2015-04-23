package com.gojava2.kickstarter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true, nullable = false, length = 15)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Project> projects;
	
	public User() {}
	
	@PersistenceConstructor
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
}