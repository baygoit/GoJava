package categories;

import java.util.ArrayList;

public class Category {

	public ArrayList<Project> category = new ArrayList<Project>();
	
	public String openCatalog(String type) {
		
		StringBuilder statistic = new StringBuilder();
		int index = 0;
		
		for (Project question : category) {
			if (type.equals(question.getType())) {
				statistic.append(++index+". "+question.showShortInformation());
			}
		}
		return statistic.toString();
	}
	
public String findProfile(int id) {
		String result = ""; 
		for (Project question : category) {
			if (id == question.getId()) {
				result = question.openProfile(id);
			}
		}
		return result;
	}
public void sendCash(int id, int money) {
	
	for (Project question : category) {
		if (id == question.getId()) {
			question.invest(money);
		}
	}
}
public void setCash(int id, int money) {
	
	for (Project question : category) {
		if (id == question.getId()) {
			question.setHaveMoney(money);
		}
	}
}

public void addComment(int id, String author, String text) {
	for (Project question : category) {
		if (id == question.getId()) {
			question.writeComment(author, text);
		}
	}
}
public void saveComment(int id, StringBuilder text) {
	for (Project question : category) {
		if (id == question.getId()) {
			question.setComments(text);
		}
	}
}
public String checkType(int id) {
	String result = ""; 
	for (Project question : category) {
		if (id == question.getId()) {
			result = question.getType();
		}
	}
	return result;
}
public String saveProject() {
	StringBuilder memory = new StringBuilder(); 
	for (Project question : category) {
		memory.append(question.savingInBase());
	}
	return memory.toString();
}
}
