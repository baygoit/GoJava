package com.epic.app.service.impl;

import com.epic.app.dao.UserAnswerDao;
import com.epic.app.model.UserAnswer;
import com.epic.app.service.UserAnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Inject
    private UserAnswerDao userAnswerDao;

    @Transactional(readOnly = false)
    @Override
    public void add(UserAnswer userAnswer) {
        userAnswerDao.save(userAnswer);
    }

    @Transactional(readOnly = false)
    @Override
    public void remove(UserAnswer userAnswer) {
        userAnswerDao.remove(userAnswer.getId());
    }

    @Transactional(readOnly = false)
    @Override
    public void saveUserAnswers(Collection<List<UserAnswer>> values) {
        for (List<UserAnswer> answers : values) {
            for (UserAnswer answer : answers) {
                userAnswerDao.save(answer);
            }
        }
    }
}
