package myRealization;

public class Kickstart {
	private int choice;
	private int projectChoice; 
	private Output output;
	private Input input;
	private Categories categories;
	private Projects projects;
	private Quote quote;
	 
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
		this.choice = choice;
		output.println("You chose - " + categories.readCategory(choice).getName());
	}

	public void showProjects() {
		int j = 1;
		projects.chooseProjects(categories.readCategory(choice));
		for (String project : projects.writeProjects()){
			output.println(j + ")" + project);
			j++;
		}
		output.println("If you want to return press \"0\"");
	}

	public void showChosenProject(int choice) {
		projectChoice = choice;
		output.println("--------------------------------------------------");
		output.println("You chose:"
				+ (projects.readProject(projectChoice)));
		for (String s : projects.giveAllInfo(projects.readObject(projectChoice))){
			output.println(s);
		}
		output.println("--------------------------------------------------");
	}
	
	public int checkForEnteringLetters(){
		int l = 0;
		while(true){
			try {
				l = input.readChoice();
				break;
			} catch (Exception e){
				output.println("Error!! You must enter numbers! - Try again:");
			}
		}
		return l;
	}
	
	public int checkForNotExistingCategory(){
		MenuPart part = new MenuPart() {
			
			@Override
			void typeError() {
				output.println("Error!! There are no such category - Try again:");
			}
			
			@Override
			int inputNumber() {
				return checkForEnteringLetters();
			}
			
			@Override
			Object getObject(int l) {
				return  categories.readCategory(l);
			}
		};
		return part.checkForCorrectInput();
	}

	public int checkForNotExistingProject(){
		MenuPart part = new MenuPart() {
			
			@Override
			void typeError() {
				output.println("Error!! There are no such project - Try again:");
			}
			
			@Override
			int inputNumber() {
				return checkForEnteringLetters();
			}
			
			@Override
			Object getObject(int l) {
				return  projects.readObject(l);
			}
		};
		return part.checkForCorrectInput();
	}
	
	public void returnToProjects(int g) {
		while (g != 0){
			output.println("Error!! You must enter 0 \nPlease, try again");
			g = checkForEnteringLetters();
		}
		showProjects();
	}
	
	public void navigate(int k) {
		while (k >= 0){
			showChosenProject(k);
			output.println("Return - \"0\"");
			returnToProjects(checkForEnteringLetters());
			k = checkForNotExistingProject();
		}
	}
	
	public void buildMenu(){
		printQuote();
		while (true){
			showList();
			int intForExit = checkForNotExistingCategory();
			if (intForExit < 0){
				break;
			} else {
				showChoice(intForExit);
			}
			showProjects();
			navigate(checkForNotExistingProject());
		}
		output.println("Thanks for using our program, Goodbye!");
	}
}
