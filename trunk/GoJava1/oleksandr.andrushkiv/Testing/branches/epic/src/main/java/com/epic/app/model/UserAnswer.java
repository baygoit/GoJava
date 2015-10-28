package com.epic.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pas8sion on 15.01.2015.
 */
@Entity
public class UserAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer id;
    @Column
    private Date testingDate;

    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answers_id")
    private Answer answer;

    @Column
    private Boolean userAnswerYesNo;

    @Column(columnDefinition = "TEXT")
    private String userAnswerText;




    public UserAnswer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTestingDate() {
        return testingDate;
    }

    public void setTestingDate(Date testingDate) {
        this.testingDate = testingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Boolean getUserAnswerYesNo() {
        return userAnswerYesNo;
    }

    public void setUserAnswerYesNo(Boolean userAnswerYesNo) {
        this.userAnswerYesNo = userAnswerYesNo;
    }

    public String getUserAnswerText() {
        return userAnswerText;
    }

    public void setUserAnswerText(String userAnswerText) {
        this.userAnswerText = userAnswerText;
    }

    @Override
    public String toString() {
        return answer.getContent();
    }

}
