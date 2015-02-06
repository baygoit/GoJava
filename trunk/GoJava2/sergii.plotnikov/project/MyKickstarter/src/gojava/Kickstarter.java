package gojava;

public class Kickstarter {

	private Categories categories;
	private IO io;
	private InputCheck check;
	
	public Kickstarter(Categories categories, IO io, InputCheck check){
		this.categories=categories;
		this.io=io;
		this.check=check;
		
	}

	public void run() {
		io.out("Welcome to the place where your dreams become real possibilities! ;)\n");
		
		categoriesMenu();
		
		io.out("Good bye! :)");
	}
	
	public void categoriesMenu() {
		Menu menu = new Menu(check){
								
			@Override
			public Object getObject(int choice) {
				return categories.getCategory(choice - 1);
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				categoryMenu((Category) object);
			}

			@Override
			public void showPositions() {
				io.out("Choose a category:\n" + categories.showCategories());
			}
		};
		menu.run(categories.getLength());
	}

	public void categoryMenu(Category tempCategory) {
		Menu menu = new Menu(check){
			
			@Override
			public Object getObject(int choice) {
				return tempCategory.getProject(choice-1);
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				projectMenu((Project) object);
			}

			@Override
			public void showPositions() {
				io.out(tempCategory.showProjects());
			}
		};
		menu.run(tempCategory.getLength());
	}

	public void projectMenu(Project tempProject) {
		Menu menu = new Menu(check){
			
			@Override
			public Object getObject(int choice) {
				return tempProject;
			}

			@Override
			public void nextSubmenu(Object object, int choice) {
				inProjectMenu((Project)object, choice);
			}

			@Override
			public void showPositions() {
				io.out(tempProject.showProject());
			}
		};
		menu.run(tempProject.getPositionsLength());
	}

	public void inProjectMenu(Project tempProject, int choice){
		while(true){
			switch(choice){
			case 1:
				io.out("Type your question:\n0 - Go back");
				String question = check.stringInputCheck();
				if(question=="0"){
					break;
				}else{
					tempProject.addQuestion(question);
				}
				break;
			case 2:
				io.out("You'll get next rewards:\n" + tempProject.showRewards());
				choice = check.menuInputCheck(tempProject.getRewardsLength()+1);
				if(choice==0){break;}
				
				int amount=0;
				if(choice<tempProject.getRewardsLength()){
					amount=tempProject.getRewardPrice(choice-1);
				}
				
				io.out("Type your name:");
				String name = check.stringInputCheck();
				if(name=="0"){
					break;
				}
				io.out("Type your card number:");
				String card = check.cardInputCheck();
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
