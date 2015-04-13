package com.epic.app.dao.impl;

import com.epic.app.dao.QuestionDao;
import com.epic.app.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
@Repository
public class QuestionDaoImpl extends AbstractHibernateDAO<Question> implements QuestionDao {
    public QuestionDaoImpl() {
        super(Question.class);
    }

    @Override
    public Question getQuestion(String number) {
       return get("number", number);
    }

    @Override
    public List<Question> getQuestionList() {
        return getAll();
    }

    @Override
    public void addQuestion(Question question) {
        save(question);
    }

    @Override
    public void removeQuestion(Question question) {
        remove(question.getId());
    }
}
