package categories;

import java.util.ArrayList;
import java.util.List;

public class Kickstarter {

	public List<Project> projects = new ArrayList<>();

	public String openCatalog(String type) { // fix all methods (try to use List
												// only) money to ammount

		StringBuilder statistic = new StringBuilder();
		int index = 0;

		for (Project project : projects) {
			
			if (type.equals(project.getType())) {
				++index;
				statistic.append(index + ". " + project.showShortInformation());
			}
		}
		return statistic.toString();
	}

	public String findProfile(int id) {
		String result = "";
		for (Project project : projects) {
			if (id == project.getId()) {
				result = project.openProfile(id);
			}
		}
		return result;
	}

	public void sendCash(int id, int money) {

		for (Project project : projects) {
			if (id == project.getId()) {
				project.invest(money);
			}
		}
	}

	public void setCash(int id, int money) {

		for (Project project : projects) {
			if (id == project.getId()) {
				project.setHaveMoney(money);
			}
		}
	}

	public void addComment(int id, String author, String text) {
		for (Project project : projects) {
			if (id == project.getId()) {
				project.writeComment(author, text);
			}
		}
	}

	public void saveComment(int id, String text) {
		for (Project project : projects) {
			if (id == project.getId()) {
				project.setComments(text);
			}
		}
	}

	public String checkType(int id) {
		String result = "";
		for (Project project : projects) {
			if (id == project.getId()) {
				result = project.getType();
			}
		}
		return result;
	}

}
