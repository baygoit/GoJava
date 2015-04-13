package com.epic.app.dao.impl;

import com.epic.app.dao.AnswerDao;
import com.epic.app.model.Answer;
import org.springframework.stereotype.Repository;

/**
 * Created by Pas8sion on 12.01.2015.
 */
@Repository
public class AnswerDaoImpl extends AbstractHibernateDAO<Answer> implements AnswerDao {

    public AnswerDaoImpl() {
        super(Answer.class);
    }

    @Override
    public Answer getAnswer(String number) {
        return get("number", number);
    }

    @Override
    public void removeAnswer(Answer answer) {
        remove(answer.getId());
    }
}
