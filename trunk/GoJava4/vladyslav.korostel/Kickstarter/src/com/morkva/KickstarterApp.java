package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.logic.ConsoleQuoter;
import com.morkva.logic.Quoter;
import com.morkva.model.*;
import com.morkva.model.impl.CategoryRepositoryImpl;
import com.morkva.model.impl.QuotesRepositoryImpl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KickstarterApp {

    static Category[] defaultCategories = new Category[]{
            new Category("Software"),
            new Category("Video"),
            new Category("Games")
    };

    static String[] questionsAndAnswers = new String[] {
            "Question 1: Answer",
            "Question 2: Answer",
            "Question 3: Answer",
            "Question 4: Answer"
    };

    static Project[] softwareCategoryProjects = new Project[] {
            new Project("Instant Messenger Qip", "A very tiny instant messenger for all Platforms and IE6", 50000, 37000, 5, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Kickstarter", "One more kickstarter", 100, 5, 31, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Global IT forum", "IT forum for all planet and our solar system", 5, 2, 100, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Project[] videoCategoryProjects = new Project[] {
            new Project("Avengers 16", "New avengers from IT developers", 500, 0, 128, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Avatar 32", "New blue people from blue planet with blue scenario, not gay", 59999000, 49999000, 256, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Batmen 64", "Need anoter one actor for batman, not gay", 699, 3, 512, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Superman 1024", "History of a developer from Crypton", 600000, 4500, 1024, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Project[] gamesCategoryProjects = new Project[] {
            new Project("256-bit mario", "New mario for Oculus Rift", 3000, 0, 60, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Quake 2.5", "Doom is too boring", 10000, 500, 31, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("CS 3.14", "New counter strike from ukrainian developers (need money for beer)", 100, 0, 3, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Quote[] defaultQuotes = new Quote[] {
            new Quote("Test Quote", "Test author"),
            new Quote("«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
            new Quote("Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
            new Quote("Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
            new Quote("Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")
    };

    private Quoter quoter;
    private CategoryRepository categoryRepository;
    private Scanner scanner;
    
    public KickstarterApp() {
    	quoter = new ConsoleQuoter(new QuotesRepositoryImpl(defaultQuotes));
        categoryRepository = new CategoryRepositoryImpl(defaultCategories);
        scanner = new Scanner(System.in);
	}

    public static void main(String[] args) throws IOException {

        defaultCategories[0].setProjects(softwareCategoryProjects);
        defaultCategories[1].setProjects(videoCategoryProjects);
        defaultCategories[2].setProjects(gamesCategoryProjects);
        
        KickstarterApp app = new KickstarterApp();
        app.showMenu();
    }
    
    public void showMenu() {
    	Category[] allCategories = categoryRepository.getAllCategories();
    	while (true) {
    		//Show quote
            System.out.println(quoter.quote());
            
            showCategories(allCategories);
            
            System.out.println();
            System.out.println("Press 0 for exit");
            System.out.println("--------------------------------------------");

//            try {
            	int keyCode = scanner.nextInt();
	            if (keyCode == 0) {
	                break;
	            } else if (keyCode > 0 && keyCode <= allCategories.length) {
	            	Category currentCategory = allCategories[keyCode-1];
	                showCategoryMenu(currentCategory);
	            } else {
	            	System.out.println("Wrong number!");
	            }
//            } catch(InputMismatchException e) {
//            	System.err.println("Please, enter only numbers!");
//            }
        }
    }
    
    public void showCategoryMenu(Category category) {
    	
    	Project[] projectsOfCurrentCategory = category.getProjects();
    	
        while (true) {
        	
            showProjectsOfCategory(category);
            
            System.out.println();
            System.out.println("Press 0 for exit from this category");
            System.out.println("--------------------------------------------");
            
            int keyCode = scanner.nextInt();
            if (keyCode == 0) {
                break;
            } else {
                if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.length) {
                	Project selectedProject = projectsOfCurrentCategory[keyCode-1];
                	showProjectMenu(selectedProject);
                } else {
                	System.out.println("Project with №" + keyCode + " does not exist");
                }
            }
        } //end projectsListLoop
    }
    
    public void showProjectMenu(Project project) {
    	while(true) {
    		
            showProjectInfo(project);
            
            System.out.println();
            System.out.println("Press 0 to return back");
            System.out.println("--------------------------------------------");
            
            int keyCode = scanner.nextInt();
            if (keyCode == 0) {
            	break;
            } else {
            	System.out.println("Wrong code!");
            }
    	} //end loop
    }
    
    public void showCategories(Category[] categories) {
    	System.out.println("Select category: ");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(i + 1 + ": " + categories[i].getName());
        }
    }
    
    public void showProjectsOfCategory(Category category) {
    	System.out.println("Category: " + category.getName());
        System.out.println("  Projects: ");
        Project[] currentCategoryProjects = category.getProjects();
        for (int i = 0; i < currentCategoryProjects.length; i++) {
            System.out.print("  " + (i + 1) + ": ");
            System.out.println(currentCategoryProjects[i].getName());
            System.out.println("	Short Description: " + currentCategoryProjects[i].getShortDescr());
            System.out.println("	Need money: " + currentCategoryProjects[i].getNeedMoney());
            System.out.println("	Current money: " + currentCategoryProjects[i].getCurrentMoney());
            System.out.println("	Days left: " + currentCategoryProjects[i].getDaysLeft());
        }
    }
    
    public void showProjectInfo(Project project) {
            System.out.println(project.getName());
            System.out.println("	Short Description: " + project.getShortDescr());
            System.out.println("	Need money: " + project.getNeedMoney());
            System.out.println("	Current money: " + project.getCurrentMoney());
            System.out.println("	Days left: " + project.getDaysLeft());
            System.out.println("	History: " + project.getHistory());
            System.out.println("	Video URL: " + project.getUrlVideo());
            System.out.println("	Questions And Answers: ");
            for (String s : project.getQuestionsAndAnswers()) {
                System.out.println("		" + s);
            }
    }
}
