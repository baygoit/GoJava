package com.gojava2.kickstarter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, max = 25, message = "Name must be at from 3 to 25 characters!")
	@NotNull(message = "Name must exist!")
	@Column(unique = true)
	private String name;
	
	@Email
	@NotNull(message = "Email must exist!")
	private String email;
	
	@Size(min = 5, message = "Password must be fromt 5 to 30 characters!")
	@NotNull(message = "Password must exist!")
	private String password;
	
	private boolean enabled;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Project> projects;
	
	@ManyToMany
	private List<Role> roles;
	
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}