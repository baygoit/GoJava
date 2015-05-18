package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.Repository;

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
    	int categoriesSize = categoryRepository.size();
        while (true) {
    		//Show quote
            println(quoteRepository.getByIndex(new Random().nextInt(quoteRepository.size())));
            
            showCategories(categoriesSize);
            
            println("");
            println("Press 0 for exit");
            println("--------------------------------------------");

            	int keyCode = reader.readUserInput();
	            if (keyCode == 0) {
	                break;
	            } else if (keyCode > 0 && keyCode <= categoriesSize) {
                    Category currentCategory = categoryRepository.getByIndex(keyCode-1);
	                showCategoryMenu(currentCategory);
	            } else {
	            	println("Wrong number!");
	            }
        }
    }
    
    public void showCategoryMenu(Category category) {
    	
    	Project[] projectsOfCurrentCategory = category.getProjects();
    	
        while (true) {
        	
            showProjectsOfCategory(category);
            
            println("");
            println("Press 0 for exit from this category");
            println("--------------------------------------------");
            
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                break;
            } else {
                if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.length) {
                	Project selectedProject = projectsOfCurrentCategory[keyCode-1];
                	showProjectMenu(selectedProject);
                } else {
                	println("Project with №" + keyCode + " does not exist");
                }
            }
        } //end projectsListLoop
    }
    
    public void showProjectMenu(Project project) {
    	while(true) {
    		
            print(project.getFullInfo());
            
            println("");
            println("Press 0 to return back");
            println("--------------------------------------------");
            
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
            	break;
            } else {
            	println("Wrong code!");
            }
    	} //end loop
    }
    
    public void showCategories(int size) {
    	println("Select category: ");
        for (int i = 0; i < size; i++) {
            println(i + 1 + ": " + categoryRepository.getByIndex(i).getName());
        }
    }
    
    public void showProjectsOfCategory(Category category) {
    	println("Category: " + category.getName());
        println("  Projects: ");
        Project[] currentCategoryProjects = category.getProjects();
        for (int i = 0; i < currentCategoryProjects.length; i++) {
            System.out.print("  " + (i + 1) + ": ");
            print(currentCategoryProjects[i].getShortInfo());
        }
    }
    
    public void print(Object o) {
    	printer.print(o);
    }
    
    public void println(Object o) {
    	print(o + "\n");
    }

    public void setCategoryRepository(Repository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setQuoteRepository(Repository<Quote> quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
}
