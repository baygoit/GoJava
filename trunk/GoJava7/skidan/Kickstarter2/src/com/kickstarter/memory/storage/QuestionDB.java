package com.kickstarter.memory.storage;

import java.util.LinkedList;
import java.util.List;

import com.kickstarter.model.Question;



public class QuestionDB {
	
	public static List<Question> questionsList;

	public QuestionDB() {

		questionsList = questionFiller();
		
		}

		

		public static List<Question> questionFiller() {
			
			List<Question> questionsList = new LinkedList<>();
			
			questionsList.add(new Question("question section","educationProjec1"));
			questionsList.add(new Question("question section","educationProjec2"));
			questionsList.add(new Question("question section","educationProjec2"));
			questionsList.add(new Question("question section","educationProjec4"));
			
			questionsList.add(new Question("question section","itproject1"));
			questionsList.add(new Question("question section","itproject2"));
			questionsList.add(new Question("question section","itproject3"));
            questionsList.add(new Question("question section","itproject4"));
            
			questionsList.add(new Question("question section","sportProjec1"));
			questionsList.add(new Question("question section","sportProjec2"));
			questionsList.add(new Question("question section","sportProjec3"));
			questionsList.add(new Question("question section","sportProjec4"));
			
			return questionsList;


		
	}
	
	
	

}
