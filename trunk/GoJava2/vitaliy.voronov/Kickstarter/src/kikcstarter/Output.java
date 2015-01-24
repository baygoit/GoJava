package kikcstarter;

public class Output {
	public void printLaoTzu(){
		System.out.println("Journey of a thousand miles \nbegins with a single step \n                   Lao Tzu");
	}

	public void menu() {
		System.out.println("Select a category: \n 1- education \n 2- finance \n 3- games");
	}
	
	public void youChoose(String choice){
		System.out.println("you chooce - " + choice);
	}

}
