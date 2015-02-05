package ua.com.goit.gojava.m__jane.model.answer;

import java.util.List;
import ua.com.goit.gojava.m__jane.model.question.PredefinedAnswer;

public class MultipleAnswer extends Answer {
	
	/*
	//user choice on every PredefinedAnswer of Question. i wanna have this information in DB
	//or create single class for relation between PredefinedAnswer and UserChoise:Boolean (with same fields)
	//and replace this map on list of those objects ?? 
	private Map<PredefinedAnswer, Boolean> choice;
*/
	
	private List<PredefinedAnswer> selectedPredefinedAnswerList;
		

	public List<PredefinedAnswer> getSelectedPredefinedAnswerList() {
		return selectedPredefinedAnswerList;
	}

	public void setSelectedPredefinedAnswerList(
			List<PredefinedAnswer> selectedPredefinedAnswerList) {
		this.selectedPredefinedAnswerList = selectedPredefinedAnswerList;
	}


	@Override
	public void checkAnswer() {
		// TODO Auto-generated method stub
		
	} 
	
}
