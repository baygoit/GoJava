package gojava;

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
							String question = menu.stringInputCheck(io);
							if(question=="0"){
								break;
							}else{
								tempProject.addQuestion(question);
							}
							break;
						case 2:
							io.out("You'll get next rewards:\n" + tempProject.showRewards());
							choice = menu.menuInputCheck(io, tempProject.getRewardsLength()+1);
							if(choice==0){break;}
							
							int amount=0;
							if(choice<tempProject.getRewardsLength()){
								amount=tempProject.getReward(choice-1).getAmount();
							}
							
							io.out("Type your name:");
							String name = menu.stringInputCheck(io);
							if(name=="0"){
								break;
							}
							io.out("Type your card number:");
							String card = menu.cardInputCheck(io);
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
		}
	}
	
	
	
}
