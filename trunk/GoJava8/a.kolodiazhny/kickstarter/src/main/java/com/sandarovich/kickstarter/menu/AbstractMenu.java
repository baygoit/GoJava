package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.category.Category;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.project.Project;
import com.sandarovich.kickstarter.project.Projects;

/**
 *  Describes common functionality for all menu existed in Project
 */

public abstract class AbstractMenu {
    static final int MENU_SHIFT = 1;

    protected final IO console;
    protected final Projects projects;
    protected final Categories categories;
    protected MenuElement[] menuElements;
    protected String headerLabel;
    protected int menuId;

    public AbstractMenu(IO console, Categories categories, Projects projects) {
        this.console = console;
        this.projects = projects;
        this.categories = categories;
    }

    public void show() {
        showMenuHeader();
        showMenuElements();
        showMenuFooter();
    }

    protected void showMenuHeader() {
        console.write("=====================");
        console.write("{" + menuId + "} " + headerLabel);
        console.write("=====================");
    }

    protected void showMenuElements() {
        if (menuElements.length == 1) {
            console.write("<< Is empty >>");
        }
        console.write("\u2193 Options:");
        console.write("----------------------");
        for (int index = 1; index < menuElements.length; index++) {
            console.write(menuElements[index].toString());
        }
    }

    protected void showMenuFooter() {
        console.write("---");
        console.write(menuElements[0].toString());
        console.write("---");
    }

    public int getUserChoice() {
        String result = console.read();
        if (isValidMenuElement(result)) {
            return Integer.parseInt(result);
        } else {
            console.write(">> Option is not found. Please try again");
            return getUserChoice();
        }
    }

    private boolean isValidMenuElement(String checkedNumber) {
        try {
            int number = Integer.parseInt(checkedNumber);
            return isValidMenuElement(number);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected boolean isValidMenuElement(int number) {
        for (MenuElement menuElement : menuElements) {
            if (menuElement.getId() == number)
                return true;
        }
        return false;
    }

    protected Actions getAction(int choice) {
        return menuElements[getMenuIndex(choice)].getAction();
    }

    public abstract void performAction(int choice);

    protected void showMainMenu() {
        AbstractMenu menu = new MainMenu(console, categories, projects);
        menu.show();
        menu.performAction(menu.getUserChoice());
    }

    protected void showCategoriesMenu() {
        AbstractMenu menu = new CategoryMenu(console, categories, projects);
        menu.show();
        menu.performAction(menu.getUserChoice());
    }

    protected void showProjectsMenu(int choice) {
        showUserInputed(menuElements[getMenuIndex(choice)]);
        Category category = categories.search(menuElements[getMenuIndex(choice)].getId() - MENU_SHIFT);
        buildProjectMenu(category);
    }

    protected void showProjectsMenu(Category category) {
        buildProjectMenu(category);
    }


    private void buildProjectMenu(Category category) {
        AbstractMenu projectMenu = new ProjectMenu(console, categories, projects,
                projects.getByCategory(category));
        projectMenu.show();
        projectMenu.performAction(projectMenu.getUserChoice());
    }


    protected void showProjectDetailsMenu(int choice) {
        showUserInputed(menuElements[getMenuIndex(choice)]);
        Project project = projects.search(menuElements[getMenuIndex(choice)].getId());
        AbstractMenu projectDetailsMenu = new ProjectDetailsMenu(console, categories, projects, project);
        projectDetailsMenu.show();
        projectDetailsMenu.performAction(projectDetailsMenu.getUserChoice());
    }

    private void showUserInputed(MenuElement menuElement) {
        console.write(">> " + menuElement.toString());
    }

    private int getMenuIndex(int choice) {
        for (int i = 0; i < menuElements.length; i++) {
            if (menuElements[i].getId() == choice) {
                return i;
            }
        }
        return -1;
    }
}
