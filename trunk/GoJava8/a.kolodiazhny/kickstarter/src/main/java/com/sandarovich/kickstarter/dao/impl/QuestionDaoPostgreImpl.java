package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuestionDaoPostgreImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Question> getQuestions(Project project) {
        return project.getQuestions();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    @Override
    public void addQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.save(question);
        session.flush();
    }
}
