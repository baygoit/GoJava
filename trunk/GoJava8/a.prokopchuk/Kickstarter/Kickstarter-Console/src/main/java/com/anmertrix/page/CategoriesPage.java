package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Quote;

public class CategoriesPage implements Page {
	
	private QuoteDao quoteDao;
    private CategoryDao categoryDao;
    private IO io;

	@Override
	public void viewPage(ViewPage viewPage) {
		this.quoteDao = viewPage.getQuoteDao();
		this.categoryDao = viewPage.getCategoryDao();
		this.io = viewPage.getIo();
		
		io.println(getQuoteText());
		showCategoriesMenu();
		
		
		boolean isExitSelect;
		do {
			isExitSelect = false;
			try {	
				int selectedMenuItemCategory = viewPage.getInputNumber();
				if (selectedMenuItemCategory == EXIT_INPUT) {
					viewPage.setPage(new ExitPage());
				} else {
					viewPage.setSelectedMenuItemCategory(selectedMenuItemCategory);
					viewPage.setPage(new ProjectsPage());
				}
				categoryDao.getCategory(selectedMenuItemCategory);
			} catch (Exception e) {
				io.print("There is no such category! Plese, select right menu item...");
				isExitSelect = true;
			}
		} while (isExitSelect);
	}
	
	private String getQuoteText() {
		Quote quote = quoteDao.getRandomQuote();
		return quote.getQuoteText() + " (" + quote.getAuthor() + ")";
	}
	
	private void showCategoriesMenu() {
		io.println(SOLID_LINE);
		List<Category> categories = categoryDao.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			io.print((i + 1) + " - " + categories.get(i).getName() + "    ");
		}
		io.println("0 - EXIT");
		io.println("");
		io.print("Please, select category...");
	}	

}
