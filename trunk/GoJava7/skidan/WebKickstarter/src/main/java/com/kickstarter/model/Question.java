package com.kickstarter.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "questions")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 5, max = 150, message = "Your question is too short input minimum 5 - 150 characters")
    @NotEmpty(message = "Please enter your question here.")
    private String question;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    public Question() {

    }

    public Question(String question, Project project) {
        this.question = question;
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String toString() {
        return question;
    }

}
