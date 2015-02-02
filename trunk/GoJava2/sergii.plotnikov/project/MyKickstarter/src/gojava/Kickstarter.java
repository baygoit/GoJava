package gojava;
import java.util.InputMismatchException;


public class Kickstarter {

	private Categories categories;
	private Output output;
	private Input input;
	
	public Kickstarter(Categories categories, Output output, Input input){
		this.categories=categories;
		this.output=output;
		this.input=input;
	}

	public void run() {
		output.out(output.hello());
		int choice;
				
		while(true){
			output.out("Choose a category:\n" + categories.showList());
						
			choice=menuInputCheck(categories.getLength());
			if(choice==0){break;}
			
			MyCategory temp = categories.getCategory(choice - 1);
			
			while(true){
				output.out(output.projectsMenu(temp));
				
				choice = menuInputCheck(temp.getLength());
				if(choice==0){break;}
				
				while(true){
					output.out(output.showProject(temp.getProject(choice-1)));
					
					choice = menuInputCheck(0);
					if(choice==0){break;}
				}
			}
		}
	}
	
	public int menuInputCheck(int length){
		try{
			int choice=input.choose();
			if (choice<0||choice>length){
				output.out("Wrong input!!!\nChoose again!");
				return menuInputCheck(length);
			}else{
				return choice;
			}
		} catch(InputMismatchException ex){
			output.out("Wrong input!!!\nChoose again!");
			return menuInputCheck(length);
		}
	}
}
