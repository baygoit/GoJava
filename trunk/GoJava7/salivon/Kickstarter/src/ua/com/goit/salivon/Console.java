/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Оля
 */
public class Console {

    private static final String WELCOME_SCENE = "WELCOME";
    private static final String CATEGORY_SCENE = "CATEGORY";
    private static final String PROJECT_SCENE = "PROJECT";
    private StringBuilder scene;
    private StoreCategories categories;
    private StoreProjects projects;
    private Quotes quotes;
    private String stateScene;
    private int indexCategory;
    private int indexProject;

    public Console() {
        scene = new StringBuilder();
        categories = new StoreCategories();
        projects = new StoreProjects();
        quotes = new Quotes();
        stateScene = WELCOME_SCENE;
    }

    public void managerScene() {
        if (stateScene == WELCOME_SCENE) {
            createWelcomScene();
            print();

        }
        if (stateScene == CATEGORY_SCENE) {
            createCategoryScene(indexCategory);
            print();

        }
        if (stateScene == PROJECT_SCENE) {
            createProjectScene(indexProject);
            print();

        }
        reader();

    }

    private void reader() {
        Scanner scan = new Scanner(System.in);
        String line = scan.next();
        HendlingError hend = new HendlingErrorFactory().getHendlingError(stateScene, categories, projects);
        if (!hend.validate(line)) {
            System.out.println("Enter the correct data!!!");
            reader();
        }
        processingOfData(line);
        managerScene();

    }

    private void processingOfData(String str) {

        if (str.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        int n = Integer.parseInt(str);
        if (n == 0) {
            if (stateScene == CATEGORY_SCENE) {
                stateScene = WELCOME_SCENE;
            }
            if (stateScene == PROJECT_SCENE) {
                stateScene = CATEGORY_SCENE;

            }
        }
        if (n != 0) {
            if (stateScene == CATEGORY_SCENE) {
                stateScene = PROJECT_SCENE;
                indexProject = n;

            }

            if (stateScene == WELCOME_SCENE) {
                stateScene = CATEGORY_SCENE;
                indexCategory = n;

            }

        }
    }

    private void print() {
        System.out.println(scene);
    }

    private void createWelcomScene() {
        if (scene.length() >= 1) {
            scene.delete(0, scene.length());
        }

        scene.append(quotes.getQuote() + "\n");
        scene.append(categories.getAllCategories());
        scene.append("--------------------------------------------------\n");
        scene.append("Enter number category or enter 'q' to exit." + "\n");
    }

    private void createCategoryScene(int idCategory) {
        int index = idCategory - 1;
        scene.delete(0, scene.length());
        scene.append("Category - ");
        Category cat = categories.getCategory(index);
        scene.append(cat.getId() + " " + cat.getName() + "\n\n");
        scene.append("Projects:\n");
        List<Project> list = projects.getProjects();
        for (Project list1 : list) {
            if (list1.getIdCategory() == index) {
                scene.append(list1.getId() + " - " + list1.getTitle() + "\n");
                scene.append("  Description: " + list1.getDescription() + "\n");
                scene.append("  Total " + list1.getTotal() + "\n");
                scene.append("  Collected amount " + list1.getCollectedAmount() + "\n");
                scene.append("  Number of days to end " + list1.getNumberOfDaysToEnd() + "\n\n");
            }
        }
        scene.append("--------------------------------------------------\n");
        scene.append("Enter number project or enter 'q' to exit,\nor enter 0 return to above." + "\n");
    }

    private void createProjectScene(int idProject) {
        int index = idProject - 1;
        scene.delete(0, scene.length());
        scene.append("Project\n");
        Project project = projects.getProject(index);
        scene.append(project.getTitle()+"\n");
        scene.append("Enter 'q' to exit,\nor enter 0 return to above." + "\n");
    }
}
