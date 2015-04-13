package com.epic.app.controllers;

import com.epic.app.model.Answer;
import com.epic.app.service.AnswerService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pas8sion on 13.01.2015.
 */

@Named
@Scope("session")
public class AnswerMB implements Serializable {

    private static final long serialVersionUID = 33L;
    @Inject
    private AnswerService answerService;

    private List<Answer> answersList = new ArrayList<Answer>();
    private String number;
    private String content;
    private Boolean answerCorrect;

    public AnswerMB() {
    }

    @PostConstruct
    public void init() {

    }


    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public String deleteRowAnswer(Answer answer) {

        answersList.remove(answer);
        return null;
    }

    public Boolean getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(Boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
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

    public String addAnswer() {

        Answer answer = new Answer();
        answer.setNumber(getNumber());
        answer.setContent(getContent());
        answer.setCorrectAnswer(getAnswerCorrect());

        answersList.add(answer);
        return null;
    }


    public void clearAnswersList() {
        answersList.clear();
    }
}
