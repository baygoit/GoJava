package ua.com.goit.gojava.m__jane.model.answer;

import java.util.Map;

import ua.com.goit.gojava.m__jane.model.question.PredefinedAnswer;

public class MultipleAnswer extends Answer {
	
	//user choice on every PredefinedAnswer of Question. i wanna have this information in DB
	//or create single class for relation between PredefinedAnswer and UserChoise:Boolean (with same fields)
	//and replace this map on list of that objects ?? 
	private Map<PredefinedAnswer, Boolean> choice;

	public Map<PredefinedAnswer, Boolean> getChoice() {
		return choice;
	}

	public void setChoice(Map<PredefinedAnswer, Boolean> choice) {
		this.choice = choice;
	}

	@Override
	public void checkAnswer() {
		// TODO Auto-generated method stub
		
	} 
	
}
