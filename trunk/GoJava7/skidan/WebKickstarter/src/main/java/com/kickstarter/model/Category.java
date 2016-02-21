package com.kickstarter.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int id;
    @Column(name = "categoryTitle")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Collection<Project> project = new ArrayList<>();

    public Category() {

    }

    public Category(int id, String title, Collection<Project> project) {
		super();
		this.id = id;
		this.title = title;
		this.project = project;
	}

	public Category(String title, int id) {
        this.title = title;
        this.id = id;

    }

    public Collection<Project> getProject() {
        return project;
    }

    public void setProject(Collection<Project> project) {
        this.project = project;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return title;
    }

}
