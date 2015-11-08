package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.dao.common.BasicCrudDao;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerDAO extends BasicCrudDao<QuestionAndAnswer> {

    List<QuestionAndAnswer> getListByProject(Project project);

}
