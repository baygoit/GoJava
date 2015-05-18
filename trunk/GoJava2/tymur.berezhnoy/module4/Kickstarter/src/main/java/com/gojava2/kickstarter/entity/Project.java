package com.gojava2.kickstarter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Transient
	private final char symbolDollar = 36;
	
	@Size(min = 2, max = 100, message = "Name must be at least 2 characters!")
	@NotNull(message = "Name must exist!")
	private String name;
	
	@Size(max = 500, message = "Description must be maximum 500 characters!")
	private String description;
	
	@Size(max = 500, message = "Story must be maximum 500 characters!")
	private String story;
	
	@URL(message = "Not valid URL!")
	private String link;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "status_id")
	private ProjectStatus status;
	
	@OneToMany(mappedBy = "project", fetch=FetchType.EAGER)
    private List<FAQ> faq;
	
	public Project() {}
	
	@PersistenceConstructor
	public Project(String name, String description, String story, String link, Category category, ProjectStatus status, User user) {
		this.name = name;
		this.description = description;
		this.story = story;
		this.link = link;
		this.category = category;
		this.status = status;
		this.user = user;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	public String getStory() {
		return story;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
	public Category getCategory() {
		return category;
	}
	
	public char getSymbolDollar() {
		return symbolDollar;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	
	public ProjectStatus getStatus() {
		return status;
	}

	public void setFaq(List<FAQ> faq) {
		this.faq = faq;
	}
	
	public List<FAQ> getFaq() {
		return faq;
	}
}