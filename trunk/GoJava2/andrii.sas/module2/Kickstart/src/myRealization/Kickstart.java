package myRealization;

public class Kickstart {
	private Output output;
	private Input input;
	private Categories categories;
	private Projects projects;
	private Quote quote;
	private Category category;
	 
	public Kickstart(Output output, Input input, Categories categories, Projects projects, Quote quote) {
		this.output = output;
		this.input = input;
		this.categories = categories;
		this.projects = projects;
		this.quote = quote;
		
	}
	
	public void printQuote() {
		output.println(quote.generateQuote());
	}

	public void showList() {
		output.println(categories.getCategories() + "\nWhat are you interested in? Pleace, make your choice:");
	}

	public void showChoice(int choice) {
		category = categories.readCategory(choice);
		output.println("You chose - " + category.getName());
	}
	
	public void receiveProjectsByCategory() {
		projects.chooseProjects(category);
	}

	public void showProjects() {
		int j = 1;
		for (String project : projects.writeProjects()){
			output.println(j + ")" + project);
			j++;
		}
		output.println("If you want to return press \"0\"");
	}

	public void showChosenProject(int projectChoice) {
		output.println("--------------------------------------------------");
		output.println("You chose:"
				+ (projects.readProject(projectChoice)));
		for (String s : projects.giveAllInfo(projects.readObject(projectChoice))){
			output.println(s);
		}
		output.println("--------------------------------------------------");
	}
	
	public void buildMenu(){
		printQuote();
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				showList();
			}
			
			@Override
			public void displayError() {
				output.println("Error!! There are no such category - Try again:");
			}

			@Override
			public void displaySelectedItems() {
				showChoice(getCheckedValue());
				receiveProjectsByCategory();
			}

			@Override
			public void toNextLevel() {
				goToProjectsMenu();
			}
		};
		menu.run(categories.getLenth());
		output.println("Thanks for using our program, Goodbye!");
	}
	
	public void goToProjectsMenu(){
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				showProjects();
			}
			
			@Override
			public void displayError() {
				output.println("Error!! There are no such project - Try again:");
			}
			
			@Override
			public void displaySelectedItems() {
				showChosenProject(getCheckedValue());
			}
			
			@Override
			public void toNextLevel() {
				goToProjecDetails();
			}
		};
		menu.run(projects.getLenth());
	}

	public void goToProjecDetails(){
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				output.println("Return - \"0\"");
			}
			
			@Override
			public void displayError() {
				output.println("Error!! You must enter 0 \nPlease, try again");
			}
			
			@Override
			public void displaySelectedItems() {
				//TODO
			}
			
			@Override
			public void toNextLevel() {
				//TODO
			}
		};
		menu.run(0);
	}
}
