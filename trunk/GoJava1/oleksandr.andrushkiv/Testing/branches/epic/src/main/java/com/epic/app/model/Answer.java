package com.epic.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Pas8sion on 10.01.2015.
 */
@Entity
public class Answer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer id;
    @NotEmpty
    @Column
    private String number;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column
    private Boolean correctAnswer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question questionOwner;


    public Answer() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question getQuestionOwner() {
        return questionOwner;
    }

    public void setQuestionOwner(Question questionOwner) {
        this.questionOwner = questionOwner;
    }

    @Override
    public String toString() {
        return number +". "+ content;
    }
}

