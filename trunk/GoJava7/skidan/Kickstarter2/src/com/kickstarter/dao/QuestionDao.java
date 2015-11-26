package com.kickstarter.dao;

import com.kickstarter.dao.interfaces.DbQuestionDaoImpl;
import com.kickstarter.dao.interfaces.QuestionDaoType;

public class QuestionDao extends QuestionDaoType {
	
	public QuestionDao(){
		
		questionDaoInterface = new DbQuestionDaoImpl();
	}

}
