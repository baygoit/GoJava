package gojava;

public class Kickstarter {

	private Categories categories;
	private IO io;
	private Menu menu;
	
	public Kickstarter(Categories categories, IO io){
		this.categories=categories;
		this.io=io;
		menu = new Menu(io);
	}

	public void run() {
		io.out("Welcome to the place where your dreams become real possibilities! ;)\n");
		
		categoriesMenu();
		
		io.out("Good bye! :)");
	}
	
	public void categoriesMenu() {
		while(true){
			io.out("Choose a category:\n" + categories.showCategories());
						
			int choice=menu.menuInputCheck(categories.getLength());
			if(choice==0){break;}
			
			Category tempCategory = categories.getCategory(choice - 1);
			
			categoryMenu(tempCategory);
			
		}
	}

	public void categoryMenu(Category tempCategory) {
		while(true){
			io.out(tempCategory.showProjects());
			
			int choice = menu.menuInputCheck(tempCategory.getLength());
			if(choice==0){break;}
			
			Project tempProject = tempCategory.getProject(choice-1);
			
			projectMenu(tempProject);
			
		}
	}

	public void projectMenu(Project tempProject) {
		while(true){
			io.out(tempProject.showProject());
			
			int choice = menu.menuInputCheck(tempProject.positions);
			if(choice==0){break;}
			
			inProjectMenu(tempProject, choice);
		}
	}

	public void inProjectMenu(Project tempProject, int choice){
		while(true){
			switch(choice){
			case 1:
				io.out("Type your question:\n0 - Go back");
				String question = menu.stringInputCheck();
				if(question=="0"){
					break;
				}else{
					tempProject.addQuestion(question);
				}
				break;
			case 2:
				io.out("You'll get next rewards:\n" + tempProject.showRewards());
				choice = menu.menuInputCheck(tempProject.getRewardsLength()+1);
				if(choice==0){break;}
				
				int amount=0;
				if(choice<tempProject.getRewardsLength()){
					amount=tempProject.getReward(choice-1).getAmount();
				}
				
				io.out("Type your name:");
				String name = menu.stringInputCheck();
				if(name=="0"){
					break;
				}
				io.out("Type your card number:");
				String card = menu.cardInputCheck();
				if(card=="0"){
					break;
				}
				if(choice==(tempProject.getRewardsLength()+1)){
					io.out("Type amount:");
					amount = io.input();
				}
				if(amount==0){
					break;
				}
				Payment p = new Payment(name, card, amount);
				tempProject.makePayment(p, amount);
				break;
			}
			break;
		}
	}
	
	
	
}
