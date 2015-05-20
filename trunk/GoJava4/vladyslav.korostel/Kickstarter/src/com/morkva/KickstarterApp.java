package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.Repository;
import com.morkva.ui.CategoriesPage;

import java.util.List;
import java.util.Random;

public class KickstarterApp {

    private Repository<Category> categoryRepository;
    private Repository<Quote> quoteRepository;

    private Reader reader;
	private Printer printer;
    
    public KickstarterApp(Printer printer, Reader reader) {
    	this.printer = printer;
        this.reader = reader;
	}

    
    public void run() {
    	int categoriesCount = categoryRepository.size();
        while (true) {
            showQuote();
            
            CategoriesPage categoriesPage = new CategoriesPage(printer, reader, categoryRepository);
            categoriesPage.showCategories();
            
            println("");
            println("Press 0 for exit");
            println("--------------------------------------------");

            	int categoryNumber = reader.readUserInput();
	            if (categoryNumber == 0) {
	                break;
	            } else if (categoryNumber > 0 && categoryNumber <= categoriesCount) {
                    Category currentCategory = categoryRepository.getByIndex(categoryNumber-1);
	                categoriesPage.showMenu(currentCategory);
	            } else {
	            	println("Wrong number!");
	            }
        }
    }

    private void showQuote() {
        println(quoteRepository.getByIndex(new Random().nextInt(quoteRepository.size())));
    }
    
    public void print(Object o) {
    	printer.print(o);
    }
    
    public void println(Object o) {
    	print(o + "\n");
    }

    public void setCategoryRepository(Repository<Category> categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setQuoteRepository(Repository<Quote> quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
}
