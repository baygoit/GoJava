package com.epic.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */

@Entity
//@Table
public class Question implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;
    @NotEmpty
    @Column(unique = true)
    private String number;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    //@NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "questionOwner")
    private List<Answer> answers;

    /**
     * if openQuestion==false then question has many variants of answers(a,b,c.... ), else only one (text the expected response)
     */
    @NotNull
    @Column
    private Boolean openQuestion;

    public Question() {
    }
    public Question(String number, String content) {
        this.number = number;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number +". "+ content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Boolean getOpenQuestion() {
        return openQuestion;
    }

    public void setOpenQuestion(Boolean openQuestion) {
        this.openQuestion = openQuestion;
    }
}
