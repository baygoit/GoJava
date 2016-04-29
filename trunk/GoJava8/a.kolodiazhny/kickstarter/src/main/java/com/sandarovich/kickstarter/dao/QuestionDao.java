package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;

import java.util.List;

public interface QuestionDao {
    void addQuestion(Question question);

    List<Question> getQuestions(Project project);
}
