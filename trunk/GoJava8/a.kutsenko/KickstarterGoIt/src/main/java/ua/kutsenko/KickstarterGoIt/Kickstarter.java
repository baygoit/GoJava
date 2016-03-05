package ua.kutsenko.KickstarterGoIt;

public class Kickstarter {
	Quotes quotes = new Quotes();
	Category category = new Category();
	

	public void run() {
		quotes.printQuote();
		category.test();
		/*category.showCategory();
		category.initCategory();
		category.selectCategory();
		category.showProject(); */
		
	}

}
