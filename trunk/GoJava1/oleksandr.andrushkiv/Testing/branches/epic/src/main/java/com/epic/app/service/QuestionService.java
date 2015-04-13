package com.epic.app.service;

import com.epic.app.model.Question;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
public interface QuestionService {
    public List<Question> getAllQuestions();

    public void addQuestion(Question question);

    public Question getQuestion(String number);
    public void removeQuestion(Question question);
}
