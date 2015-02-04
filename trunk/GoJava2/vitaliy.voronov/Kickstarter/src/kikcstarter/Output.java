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
	
	public void printZero(){
		System.out.println("0) MAIN MANU");
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
	public void printSelectProject(Project project2) {
			System.out.println(project2.getName() + "\n " + project2.getDescription() + "\n We need - " 
					+ project2.getNeedMoney() + "$\n We have - " + project2.getHaveMoney() + "$\n Time over - " + 
					project2.getDaysBeforeEnd() + " days" + project2.getProjectHistory() + "\n " + project2.getLinkToDemoVideo() + 
					"\n " + project2.getQuastionAnswer());
		
	}

	/*
	 * public void printaaa(int i){ for(ArrayList list : projects){
	 * if(i==list.getCategory()){ System.out.println(); } } }
	 */
}
