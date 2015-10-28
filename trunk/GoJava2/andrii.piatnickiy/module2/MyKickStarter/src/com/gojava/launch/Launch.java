package com.gojava.launch;


import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.InFileCategoryStorage;
import com.gojava.projects.InFileProjectStorage;
import com.gojava.projects.InMemoryCategoryStorage;
import com.gojava.projects.InMemoryProjectStorage;
import com.gojava.projects.ProjectStorage;
import com.gojava.quote.Quote;
import com.gojava.view.Menu;

public class Launch {

    public static void main(String[] args) throws Exception {
        ConsoleIO consoleIO = new  ConsoleIO();


        CategoryStorage categoryStorage = new InFileCategoryStorage("categories.txt");
//        CategoryStorage categoryStorage = new InMemoryCategoryStorage();
        
        ProjectStorage projectStorage = new InFileProjectStorage("projects.txt");
//        ProjectStorage projectStorage = new InMemoryProjectStorage();

        
        initCategories(categoryStorage);
        //TODO remade cast
        ((InFileCategoryStorage) categoryStorage).getCategoriesFromFileToList();
        initProjects(projectStorage);
      //TODO remade cast
        ((InFileProjectStorage) projectStorage).getProjectsFromFileToList();
        Quote quote = new Quote(consoleIO);
        quote.consoleIO.print(quote.getQuote());

        Menu menu = new Menu(categoryStorage, projectStorage, consoleIO);
        while (true) {
            menu.printNextLevel(menu.out.inputInt());
        }

    }

    private static void initProjects(ProjectStorage projectStorage) {
        projectStorage.add("Bicycle", "Bicycle description", 10000, 100, 10,
                "History", "Link on video", "Questions and answers", 1);
        projectStorage.add("Snowboard", "Snowboard description", 2000, 200, 20,
                "History", "Link on video", "Questions and answers", 1);
        projectStorage.add("BMW X3", "BMW X3 description", 30000, 3000, 300,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Audi Q5", "Audi Q5 description", 40000, 400, 40,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Laptop", "Laptop description", 500, 50, 50,
                "History", "Link on video", "Questions and answers", 3);
        projectStorage.add("Mobile phone", "Mobile phone description", 60, 60,
                6, "History", "Link on video", "Questions and answers", 3);
    }

    private static void initCategories(CategoryStorage categoryStorage) {
        categoryStorage.add("Sport", 1);
        categoryStorage.add("Car", 2);
        categoryStorage.add("Devices", 3);
    }
}
