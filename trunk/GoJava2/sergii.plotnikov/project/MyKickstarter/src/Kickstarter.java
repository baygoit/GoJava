
public class Kickstarter {

	private static Categories categories = new Categories();
	private static Output output = new Output();
	private static Input input = new Input();
	
	public void run(){
		output.hello();
		categories.addCategories();
		
		output.categoriesMenu(categories);
		output.projectsMenu(categories.getCategory(input.chooseCategory()-1));
	}
}
