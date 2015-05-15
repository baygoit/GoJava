package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.Repository;
import com.morkva.model.impl.RepositoryImpl;

public class KickstarterApp {

    static Category[] defaultCategories = new Category[]{
            new Category(1, "Software"),
            new Category(2, "Video"),
            new Category(3, "Games")
    };

    static String[] questionsAndAnswers = new String[] {
            "Question 1: Answer",
            "Question 2: Answer",
            "Question 3: Answer",
            "Question 4: Answer"
    };

    static Project[] softwareCategoryProjects = new Project[] {
            new Project(1, "Instant Messenger Qip", "A very tiny instant messenger for all Platforms and IE6", 50000, 37000, 5, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(2, "Kickstarter", "One more kickstarter", 100, 5, 31, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(3, "Global IT forum", "IT forum for all planet and our solar system", 5, 2, 100, "History of the project", "http://youtube.com/kdjh1231")
    };

    static Project[] videoCategoryProjects = new Project[] {
            new Project(4, "Avengers 16", "New avengers from IT developers", 500, 0, 128, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(5, "Avatar 32", "New blue people from blue planet with blue scenario, not gay", 59999000, 49999000, 256, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(6, "Batmen 64", "Need anoter one actor for batman, not gay", 699, 3, 512, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(7, "Superman 1024", "History of a developer from Crypton", 600000, 4500, 1024, "History of the project", "http://youtube.com/kdjh1231")
    };

    static Project[] gamesCategoryProjects = new Project[] {
            new Project(8, "256-bit mario", "New mario for Oculus Rift", 3000, 0, 60, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(9, "Quake 2.5", "Doom is too boring", 10000, 500, 31, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(10, "CS 3.14", "New counter strike from ukrainian developers (need money for beer)", 100, 0, 3, "History of the project", "http://youtube.com/kdjh1231")
    };

    static Quote[] defaultQuotes = new Quote[] {
            new Quote(1, "Test Quote", "Test author"),
            new Quote(2, "«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
            new Quote(3, "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
            new Quote(4, "Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
            new Quote(5, "Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")
    };

    private Quoter quoter;
    private Repository<Category> categoryRepository;

    private Reader reader;
	private Printer printer;
    
    public KickstarterApp(Printer printer) {
    	this.printer = printer;
        this.reader = new ConsoleReader(printer);
        categoryRepository = new RepositoryImpl<>(defaultCategories);
        quoter = new ConsoleQuoter(new RepositoryImpl<>(defaultQuotes));

        defaultCategories[0].setProjects(softwareCategoryProjects);
        defaultCategories[1].setProjects(videoCategoryProjects);
        defaultCategories[2].setProjects(gamesCategoryProjects);
	}

    
    public void showMenu() {
    	int categoriesSize = categoryRepository.size();
        while (true) {
    		//Show quote
            quoter.showQuote();
            
            showCategories(categoriesSize);
            
            println("");
            println("Press 0 for exit");
            println("--------------------------------------------");

            	int keyCode = reader.readUserInput();
	            if (keyCode == 0) {
	                break;
	            } else if (keyCode > 0 && keyCode <= categoriesSize) {
                    System.out.println("KEY CODE = " + keyCode);
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
    		
            project.showFullInfo();
            
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
            currentCategoryProjects[i].setPrinter(printer);
            currentCategoryProjects[i].showShortInfo();
        }
    }
    
    public void print(Object o) {
    	printer.print(o);
    }
    
    public void println(Object o) {
    	print(o + "\n");
    }
}
