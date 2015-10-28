package com.epic.app.service;

import com.epic.app.model.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Service
public interface UserAnswerService {
    public void add(UserAnswer userAnswer);
    public void remove(UserAnswer userAnswer);

    public void saveUserAnswers(Collection<List<UserAnswer>> values);
}
