package gojava;

import java.util.InputMismatchException;

public class Kickstarter {

	private Categories categories;
	private IO io;
	private Menu menu;
	
	public Kickstarter(Categories categories, IO io, Menu menu){
		this.categories=categories;
		this.io=io;
		this.menu=menu;
	}

	public void run() {
		io.out("Welcome to the place where your dreams become real possibilities! ;)\n");
		int choice;
				
		while(true){
			io.out("Choose a category:\n" + categories.showCategories());
						
			choice=menu.menuInputCheck(io, categories.getLength());
			if(choice==0){
				io.out("Good bye! :)");
				break;
			}
			
			Category tempCategory = categories.getCategory(choice - 1);
			
			while(true){
				io.out(tempCategory.showProjects());
				
				choice = menu.menuInputCheck(io, tempCategory.getLength());
				if(choice==0){break;}
				
				Project tempProject = tempCategory.getProject(choice-1);
				
				while(true){
					io.out(tempProject.showProject());
					
					choice = menu.menuInputCheck(io, tempProject.positions);
					if(choice==0){break;}
					
					while(true){
						switch(choice){
						case 1:
							io.out("Type your question:\n0 - Go back");
							String question = io.stringInput();
							if(question.equals("") || question.equals("0")){
								break;
							}else{
								tempProject.addQuestion(question);
							}
							break;
						case 2:
							io.out("Type your name:");
							String name = io.stringInput();
							io.out("Type your card number:");
							String card = io.stringInput();
							io.out("Type amount:");
							int amount = io.input();
							Payment p = new Payment(name, card, amount);
							tempProject.makePayment(p, amount);
							break;
						}
						break;
					}
					
				}
			}
		}
	}
	
	
	
}
