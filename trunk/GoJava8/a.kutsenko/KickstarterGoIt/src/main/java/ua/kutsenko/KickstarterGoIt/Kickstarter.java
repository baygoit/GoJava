package ua.kutsenko.KickstarterGoIt;

public class Kickstarter {
	Quotes quotes = new Quotes();
	Category category = new Category();
	Category selectedCategory = new Category();
  
	
	public void run() {
		quotes.printQuote();
		category.initCategory();
		while(true){
		category.showCategory();
		selectedCategory = category.selectCategory();
		category.showProjects(selectedCategory);
		category.selectProject(selectedCategory);
        }
		
	}

}
