package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
import com.tyomsky.kickstarter.service.QuestionAndAnswerService;

import java.util.List;

public class QuestionAndAnswerImpl implements QuestionAndAnswerService {

    QuestionAndAnswerDAO questionAndAnswerDAO;

    public QuestionAndAnswerImpl(QuestionAndAnswerDAO questionAndAnswerDAO) {
        this.questionAndAnswerDAO = questionAndAnswerDAO;
    }


    @Override
    public List<QuestionAndAnswer> getListByProject(Project project) {
        return questionAndAnswerDAO.getListByProject(project);
    }

    @Override
    public QuestionAndAnswer save(QuestionAndAnswer questionAndAnswer) {
        return questionAndAnswerDAO.save(questionAndAnswer);
    }
}
