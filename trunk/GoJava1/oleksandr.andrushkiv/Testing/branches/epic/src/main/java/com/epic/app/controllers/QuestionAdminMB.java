package com.epic.app.controllers;

import com.epic.app.model.Answer;
import com.epic.app.model.Question;
import com.epic.app.service.QuestionService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Pas8sion on 02.01.2015.
 */

//@ManagedBean
//@SessionScoped
@Named
@Scope("session")
public class QuestionAdminMB implements Serializable {

    private static final long serialVersionUID = 3L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Inject
    private QuestionService questionService;

    @Inject
    private AnswerMB answerMB;

    private String number;
    private String content;
    private Boolean openQuestion;


    @PostConstruct
    public void init() {

    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void addQuestion() {
        Question question = getQuestionForSave();
        try {
            getQuestionService().addQuestion(question);
            //return SUCCESS;
            addMessage("Question added", FacesMessage.SEVERITY_INFO);
        } catch (DataAccessException e) {
            addMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
        reset();
        //return ERROR;
    }

    private Question getQuestionForSave(){

        Question question = getQuestionService().getQuestion(getNumber().trim());
        //TODO ask user about update question
        if (question == null) question = new Question();

        question.setNumber(getNumber().trim());
        question.setContent(getContent().trim());
        question.setOpenQuestion(getOpenQuestion());

        List<Answer> answersList = answerMB.getAnswersList();
        for (Answer answer : answersList) {
            answer.setQuestionOwner(question);
        }
        question.setAnswers(answersList);

        return question;
    }

    public void addMessage(String summary, FacesMessage.Severity messageType) {
        FacesMessage message = new FacesMessage(messageType, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void reset() {
        this.setNumber("");
        this.setContent("");
        this.setOpenQuestion(false);

        answerMB.setNumber("");
        answerMB.setContent("");
        answerMB.setAnswerCorrect(false);
        answerMB.clearAnswersList();
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

    public Boolean getOpenQuestion() {
        return openQuestion;
    }

    public void setOpenQuestion(Boolean openQuestion) {
        this.openQuestion = openQuestion;
    }


}
