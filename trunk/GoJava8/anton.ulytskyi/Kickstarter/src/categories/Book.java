package categories;

import java.util.ArrayList;

public class Book {

	public ArrayList<Question> book = new ArrayList<Question>();
	
	public String openCatalog(String type) {
		
		StringBuilder statistic = new StringBuilder();
		int index = 0;
		
		for (Question question : book) {
			if (type.equals(question.getType())) {
				statistic.append(++index+". "+question.showShortInformation());
			}
		}
		return statistic.toString();
	}
	
public String findProfile(int id) {
		String result = ""; 
		for (Question question : book) {
			if (id == question.getId()) {
				result = question.openProfile(id);
			}
		}
		return result;
	}
public void sendCash(int id, int money) {
	
	for (Question question : book) {
		if (id == question.getId()) {
			question.invest(money);
		}
	}
}

public void addComment(int id, String author, String text) {
	for (Question question : book) {
		if (id == question.getId()) {
			question.writeComment(author, text);
		}
	}
}
public String checkType(int id) {
	String result = ""; 
	for (Question question : book) {
		if (id == question.getId()) {
			result = question.getType();
		}
	}
	return result;
}
}
