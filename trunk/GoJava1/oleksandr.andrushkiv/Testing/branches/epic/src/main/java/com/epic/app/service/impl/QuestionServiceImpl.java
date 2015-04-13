package com.epic.app.service.impl;

import com.epic.app.dao.QuestionDao;
import com.epic.app.model.Question;
import com.epic.app.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Inject
    private QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
       return questionDao.getQuestionList();
    }

    @Transactional(readOnly = false)
    @Override
    public void addQuestion(Question question) {

        if (question == null) throw new IllegalArgumentException("Question cannot be null");
        questionDao.addQuestion(question);
    }

    @Override
    public Question getQuestion(String number) {
        return questionDao.getQuestion(number);
    }

    @Transactional(readOnly = false)
    @Override
    public void removeQuestion(Question question) {
        questionDao.removeQuestion(question);
    }
}
