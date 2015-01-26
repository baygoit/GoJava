public class Kickstarter {

	private Categories categories = new Categories();
	private Output output = new Output();
	private Input input = new Input();

	public void run() {
		output.hello();
		int choice;
				
		while(true){
			output.categoriesMenu(categories);
			
			choice = input.choose();
			if(choice==0){break;}
			MyCategory temp = categories.getCategory(choice - 1);
			
			while(true){
				output.projectsMenu(temp);
				
				choice = input.choose();
				if(choice==0){break;}
				
				while(true){
					output.showProject(temp.getProject(choice-1));
					
					choice = input.choose();
					if(choice==0){break;}
				}
			}
		}
	}
}
