package com.epic.app.dao;

import com.epic.app.model.Answer;

/**
 * Created by Pas8sion on 12.01.2015.
 */
public interface AnswerDao extends BasicCrudDao<Answer> {

    public Answer getAnswer(String number);
    public void removeAnswer(Answer answer);
}
