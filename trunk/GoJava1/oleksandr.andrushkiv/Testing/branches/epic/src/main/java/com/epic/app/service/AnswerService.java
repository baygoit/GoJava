package com.epic.app.service;

import com.epic.app.model.Answer;

/**
 * Created by Pas8sion on 12.01.2015.
 */
public interface AnswerService {

    public Answer getAnswer(String number);
    public void removeAnswer(Answer answer);
}
