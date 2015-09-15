package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerService {

    List<QuestionAndAnswer> getListByProject(Project project);

    QuestionAndAnswer save(QuestionAndAnswer questionAndAnswer);

}
