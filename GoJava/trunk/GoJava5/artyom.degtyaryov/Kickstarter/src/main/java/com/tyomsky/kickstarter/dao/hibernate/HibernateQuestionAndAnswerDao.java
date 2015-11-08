package com.tyomsky.kickstarter.dao.hibernate;

import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;

import java.util.List;

public class HibernateQuestionAndAnswerDao extends AbstractHibernateDao <QuestionAndAnswer> implements QuestionAndAnswerDAO{

    public HibernateQuestionAndAnswerDao() {
        super(QuestionAndAnswer.class);
    }

    @Override
    public List<QuestionAndAnswer> getListByProject(Project project) {
        return getList("project", project);
    }
}
