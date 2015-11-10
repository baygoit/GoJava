/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

import ua.com.goit.salivon.beans.Category;
import ua.com.goit.salivon.beans.Project;
import ua.com.goit.salivon.stores.StoreProjects;
import ua.com.goit.salivon.stores.StoreCategories;
import java.util.List;

/**
 *
 * @author Оля
 */
public class CategoryScene extends ViewScene {

    private StoreCategories categories;
    private StoreProjects projects;
    private  int data;

    public CategoryScene(StoreCategories categories, StoreProjects projects, int data) {
        this.categories = categories;
        this.projects = projects;
        this.data = data;
        menu = "Enter the number of projects to select it.\n"
                + "Enter 0 return to above.\n"
                + "Enter 'q' to exit.\n";
        createScene();
    }

    @Override
    protected void createScene() {
        int index = data - 1;
        textScene.append("Category - ");
        Category cat = categories.getCategory(index);
        textScene.append(cat.getId() + " " + cat.getName() + "\n\n");
        textScene.append("Projects:\n");
        List<Project> list = projects.getProjects();
        for (Project list1 : list) {
            if (list1.getIdCategory() == index) {
                textScene.append(list1.getId() + " - " + list1.getTitle() + "\n");
                textScene.append("  Description: " + list1.getDescription() + "\n");
                textScene.append("  Total " + list1.getTotal() + "$\n");
                textScene.append("  Collected amount " + list1.getCollectedAmount() + "\n");
                textScene.append("  Number of days to end " + list1.getNumberOfDaysToEnd() + "\n\n");
            }
        }
        textScene.append("--------------------------------------------------\n");
        textScene.append(menu);
    }

}
