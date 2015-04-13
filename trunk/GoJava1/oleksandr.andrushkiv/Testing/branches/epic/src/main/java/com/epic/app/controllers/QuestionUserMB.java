package com.epic.app.controllers;

import com.epic.app.model.Answer;
import com.epic.app.model.Question;
import com.epic.app.model.User;
import com.epic.app.model.UserAnswer;
import com.epic.app.service.QuestionService;
import com.epic.app.service.UserAnswerService;
import com.epic.app.service.UserService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;


/**
 * Created by Pas8sion on 02.01.2015.
 */

@Named
@Scope("session")
public class QuestionUserMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Inject
    private QuestionService questionService;
    @Inject
    private UserAnswerService userAnswerService;
    @Inject
    private UserService userService;

    //TODO think about compare Questions
    private NavigableMap<Question,List<UserAnswer>> userAnswers = new TreeMap<Question, List<UserAnswer>>(new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            return Integer.compare(o1.getId(),o2.getId());
        }
    });
    private Map.Entry<Question,List<UserAnswer>> currentEntry;



    @PostConstruct
    public void init() {
        User user = userService.getUser("test login");
        //TODO change to real list and user
        for (Question question : questionService.getAllQuestions()) {
            List<UserAnswer> list = new ArrayList<UserAnswer>();
            for (Answer answer : question.getAnswers()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setQuestion(question);
                userAnswer.setAnswer(answer);
                userAnswer.setTestingDate(new Date());
                userAnswer.setUser(user);
                userAnswer.setUserAnswerYesNo(false);
                list.add(userAnswer);
            }
            userAnswers.put(question, list);
        }
        currentEntry = userAnswers.firstEntry();
    }

    public QuestionUserMB() {
    }

    public void getNextQuestion() {

        if (currentEntry != null){
            Map.Entry entry = userAnswers.higherEntry(currentEntry.getKey());
            if (entry!= null){
                currentEntry = entry;
            }
        }
    }

    public void getPreviousQuestion() {

        if (currentEntry != null){
            Map.Entry entry = userAnswers.lowerEntry(currentEntry.getKey());
            if (entry!= null){
                currentEntry = entry;
            }
        }
    }

    public String saveResult(){
        userAnswerService.saveUserAnswers(userAnswers.values());
        addMessage("Тестування завершено!", FacesMessage.SEVERITY_INFO);
        return "/index.xhtml";
    }

    public void addMessage(String summary, FacesMessage.Severity messageType) {
        FacesMessage message = new FacesMessage(messageType, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

                    /*-------setters/getters---------*/

    public NavigableMap<Question, List<UserAnswer>> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(NavigableMap<Question, List<UserAnswer>> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Map.Entry<Question, List<UserAnswer>> getCurrentEntry() {
        return currentEntry;
    }

    public void setCurrentEntry(Map.Entry<Question, List<UserAnswer>> currentEntry) {
        this.currentEntry = currentEntry;
    }

}
