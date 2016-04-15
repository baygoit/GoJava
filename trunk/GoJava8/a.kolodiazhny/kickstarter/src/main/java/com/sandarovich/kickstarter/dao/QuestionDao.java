package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions(Project project);
    void addQuestion(Question question, int projectId);
}
