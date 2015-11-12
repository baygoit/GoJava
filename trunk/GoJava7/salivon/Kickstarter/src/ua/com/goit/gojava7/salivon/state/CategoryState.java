/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import java.util.List;
import ua.com.goit.gojava7.salivon.handlers.HandlerErrorCategoryScene;
import ua.com.goit.gojava7.salivon.view.Console;

/**
 *
 * @author Оля
 */
public class CategoryState extends State {

    private List<Category> categories = StoreCategories.getCategories();
    private List<Project> projects = StoreProjects.getProjects();

    public CategoryState() {
        handler = new HandlerErrorCategoryScene();
        menu = "Enter the number of projects to select it.\n"
                + "Enter 0 return to above.\n"
                + "Enter 'q' to exit.\n";

    }

    @Override
    public void outputContentState() {
        int index = State.getIndexCategory();
        System.out.print("Category - ");
        Category cat = categories.get(index - 1);
        System.out.println(cat.getId() + " " + cat.getName() + "\n");
        System.out.println("Projects:");
        for (Project list1 : projects) {
            if (list1.getIdCategory() == index) {
                System.out.println(list1.getId() + " - " + list1.getTitle());
                System.out.println("  Description: " + list1.getDescription());
                System.out.println("  Total " + list1.getTotal() + "$");
                System.out.println("  Collected amount " + list1.getCollectedAmount());
                System.out.println("  Number of days to end " + list1.getNumberOfDaysToEnd() + "\n");
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println(menu);

    }

    @Override
    protected void changeState(Console context, String inData) {
        int inDateToInt = Integer.parseInt(inData);
        if (inDateToInt == 0) {
//            State.setIndexCategory(inDateToInt);
            context.setCurrentState(context.getWelcomState());
        } else {
            State.setIndexProject(inDateToInt);
            context.setCurrentState(context.getProjectState());
        }

    }
}
