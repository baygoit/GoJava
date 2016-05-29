package com.sandarovich.kickstarter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category ")
@NamedQueries({
    @NamedQuery(name = "Category.getAll", query = "SELECT c from Category as c"),
    @NamedQuery(name = "Category.getById", query = "SELECT c from Category as c WHERE c.id = :id"),
    @NamedQuery(name = "Category.isCategoryExist", query = "SELECT COUNT(c) from Category as c WHERE c.id = :id")
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Project> projects;

    public Category() {

    }

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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
