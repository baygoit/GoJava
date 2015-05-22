package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.Repository;
import com.morkva.ui.CommandType;
import com.morkva.ui.Model;
import com.morkva.ui.ViewHelper;

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
        showQuote();
        ViewHelper viewHelper = new ViewHelper(new Model(categoryRepository), printer, reader);
        while (true) {
            viewHelper.sendCommand(CommandType.SHOW_CATEGORIES_VIEW);
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
