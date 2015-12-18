package com.kickstarter.dao.impl;

import java.util.LinkedList;
import java.util.List;

import com.kickstarter.dao.interfaces.QuestionDaoInterface;
import com.kickstarter.memory.storage.QuestionDB;
import com.kickstarter.model.Question;

public class MemoryQuestionDaoImpl implements QuestionDaoInterface {
	
     QuestionDB questionDB = new QuestionDB();
	
	
	
	public List<Question> getProjectQuestions(String projectTitle){
		List<Question> allQuesstionsList =  QuestionDB.questionsList;
		List<Question> singleProjectQuesstionsList = new LinkedList<>();;
		for(Question q : allQuesstionsList){
			if(q.getProjectTitle().equals(projectTitle)){
				singleProjectQuesstionsList.add(q);
			}
		}
		
		return singleProjectQuesstionsList;
		
		
		
	}
	public void add(String newQuestion,String pojectTitle){
		QuestionDB.questionsList.add(new Question(newQuestion, pojectTitle));
	}
	
	
	
}
