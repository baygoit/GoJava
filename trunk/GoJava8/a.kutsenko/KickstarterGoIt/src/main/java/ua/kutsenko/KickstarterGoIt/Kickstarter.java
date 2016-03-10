package ua.kutsenko.KickstarterGoIt;

public class Kickstarter {
	Quotes quotes = new Quotes();
	Category category = new Category();
	Category selectedCategory = new Category();
    Project selectedProject = new Project();
    Project changeProject = new Project();
	
	public void run() {
		
		quotes.printQuote();
		category.initCategory();
		while(true){
			category.showCategory();
			selectedCategory = category.selectCategory();
			category.showProjects(selectedCategory);		
			selectedProject = category.selectProject(selectedCategory);
			changeProject = category.actionProject(selectedProject, selectedCategory);
		
		     
		}
	}

}

