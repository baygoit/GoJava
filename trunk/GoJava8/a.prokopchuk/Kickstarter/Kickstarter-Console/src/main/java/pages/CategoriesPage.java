package pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Quote;

public class CategoriesPage implements Page {
	
	ViewPage viewPage;

	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		viewPage.io.println(getQuoteText());
		showCategoriesMenu();
		int selectedMenuItemCategory = viewPage.getInputNumber();
		if (selectedMenuItemCategory == EXIT_INPUT) {
			viewPage.setPage(new ExitPage());
		} else {
			viewPage.setSelectedMenuItemCategory(selectedMenuItemCategory);
			viewPage.setPage(new ProjectsPage());
		}
	}
	
	public String getQuoteText() {
		Quote quote = viewPage.quoteDao.getRandomQuote();
		return quote.getQuoteText() + " (" + quote.getAuthor() + ")";
	}
	
	private void showCategoriesMenu() {
		viewPage.io.println(SOLID_LINE);
		List<Category> categories = viewPage.categoryDao.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			viewPage.io.print((i + 1) + " - " + categories.get(i).getName() + "    ");
		}
		viewPage.io.println("0 - EXIT");
		viewPage.io.println("");
		viewPage.io.print("Please, select category...");
	}	

}
