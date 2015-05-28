package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.IRepository;
import com.morkva.ui.Model;
import com.morkva.ui.ViewHelper;
import com.morkva.ui.ViewResolver;
import com.morkva.ui.ViewType;

import java.util.Random;

public class KickstarterApp {

    private IRepository<Category> categoryRepository;
    private IRepository<Quote> quoteRepository;

    private Reader reader;
	private Printer printer;
    
    public KickstarterApp(Printer printer, Reader reader) {
    	this.printer = printer;
        this.reader = reader;
	}

    
    public void run() {
        showQuote();
        ViewHelper viewHelper = new ViewHelper(new Model(categoryRepository), printer, reader);
        ViewResolver.getInstance().setNextView(ViewType.CATEGORIES_PAGE);
        viewHelper.runCommand();
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

    public void setCategoryRepository(IRepository<Category> categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setQuoteRepository(IRepository<Quote> quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
}
