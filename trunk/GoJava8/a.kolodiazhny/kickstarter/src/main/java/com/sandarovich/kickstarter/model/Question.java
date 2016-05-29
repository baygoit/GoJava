package com.sandarovich.kickstarter.model;


import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Question.getQuestions", query = "SELECT q FROM Question as q WHERE q.project = :project ORDER BY q.id DESC")
})
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectid")
    private Project project;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
