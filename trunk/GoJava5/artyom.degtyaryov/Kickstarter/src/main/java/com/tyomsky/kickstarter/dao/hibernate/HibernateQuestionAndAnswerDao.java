package com.tyomsky.kickstarter.dao.hibernate;

import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;

public class HibernateQuestionAndAnswerDao extends AbstractHibernateDao <QuestionAndAnswer> implements QuestionAndAnswerDAO{

    public HibernateQuestionAndAnswerDao() {
        super(QuestionAndAnswer.class);
    }

}
