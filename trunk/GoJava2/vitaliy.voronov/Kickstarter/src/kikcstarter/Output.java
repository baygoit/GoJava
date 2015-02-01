package kikcstarter;

import java.util.ArrayList;

public class Output {
	public void printQuote() {
		Quote quote = new Quote();
		System.out.println(quote.getLaoTzu());
	}

	public void menu() {
		System.out
				.println("Select a category: \n 0- MAIN MANU \n 1- EDUCATION \n 2- FINANCE \n 3- GAMES");
	}

	public void youChoose(String choice) {
		System.out.println("you chooce - " + choice);
	}

	public void printProject(ArrayList<Project> projects) {

		int i = 0;
		for (Project project : projects) {
			i++;
			System.out.println(i + ") " + project.getName() + "\n " + project.getDescription() + "\n We need - " 
					+ project.getNeedMoney() + "$\n We have - " + project.getHaveMoney() + "$\n Time over - " + 
					project.getDaysBeforeEnd() + " days");
		}
	}
	public void printSelectProject(ArrayList<Project> projects) {
		int i = 0;
		for (Project project : projects) {
			i++;
			System.out.println(i + ") " + project.getName() + "\n " + project.getDescription() + "\n We need - " 
					+ project.getNeedMoney() + "$\n We have - " + project.getHaveMoney() + "$\n Time over - " + 
					project.getDaysBeforeEnd() + " days" + project.getProjectHistory() + project.getLinkToDemoVideo() + 
					project.getQuastionAnswer());
		}
	}

	/*
	 * public void printaaa(int i){ for(ArrayList list : projects){
	 * if(i==list.getCategory()){ System.out.println(); } } }
	 */
}
