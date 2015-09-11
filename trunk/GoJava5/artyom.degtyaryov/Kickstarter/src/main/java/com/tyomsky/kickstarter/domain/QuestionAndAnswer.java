package com.tyomsky.kickstarter.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions_and_answers")
public class QuestionAndAnswer {

    @Id
    @GeneratedValue
    int id;

    private String question;

    private String answer;

    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    Project project;

    public QuestionAndAnswer() {
    }

    public QuestionAndAnswer(String question) {
        this.question = question;
    }

    public QuestionAndAnswer(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
