package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QuestionDaoPostgreImpl implements QuestionDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestions(Project project) {
        Query query = em.createNamedQuery("Question.getQuestions");
        query.setParameter("project", project);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public void addQuestion(Question question) {
        em.merge(question);
    }
}
