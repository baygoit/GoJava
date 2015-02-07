package com.gojava.launch;

import com.gojava.inputOutput.Out;
import com.gojava.inputOutput.Scan;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;
import com.gojava.quote.Quote;
import com.gojava.view.Menu;

public class Launch {

    public static void main(String[] args) {
        Out out = new Out();
        CategoryStorage categoryStorage = new CategoryStorage();
        ProjectStorage projectStorage = new ProjectStorage();

        initCategories(categoryStorage);
        initProjects(projectStorage);

        projectStorage.setOut(out);
        categoryStorage.setOut(out);

        Scan scan = new Scan();
        Quote quote = new Quote();
        out.print(quote.getQuote());

        Menu menu = new Menu(categoryStorage, projectStorage);
        while (true) {
            menu.nextLevel(scan.inputInt());
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
