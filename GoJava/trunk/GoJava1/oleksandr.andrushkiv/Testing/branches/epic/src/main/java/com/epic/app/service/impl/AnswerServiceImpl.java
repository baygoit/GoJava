package com.epic.app.service.impl;

import com.epic.app.dao.AnswerDao;
import com.epic.app.model.Answer;
import com.epic.app.service.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Pas8sion on 12.01.2015.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Inject
    private AnswerDao answerDao;

    @Override
    public Answer getAnswer(String number) {
        return answerDao.getAnswer(number);
    }

    @Transactional(readOnly = false)
    @Override
    public void removeAnswer(Answer answer) {
        answerDao.removeAnswer(answer);
    }
}
