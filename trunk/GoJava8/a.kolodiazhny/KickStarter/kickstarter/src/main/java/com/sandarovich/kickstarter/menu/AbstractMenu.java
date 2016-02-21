package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.project.Project;
import com.sandarovich.kickstarter.project.Projects;

/**
 * @author Olexander Kolodiazhny 2016
 * Describes common functionality for all menu existed in Project
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
        for (int index = 1; index < menuElements.length; index++) {
            console.write(menuElements[index].toString());
        }
    }

    protected void showMenuFooter() {
        console.write("---");
        console.write(menuElements[0].toString());
        console.write("---");
    }

    public int readUserFeedback() {
        String result = console.read();
        if (isValidMenuElement(result)) {
            return Integer.parseInt(result);
        } else {
            console.write(">> Option is not found. Please try again");
            return readUserFeedback();
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
        return number >= 0 && number < menuElements.length;
    }

    protected Actions getAction(int choice) {
        return isValidMenuElement(choice) ? menuElements[choice].getAction() : null;
    }

    public abstract void doAction(int choice);

    protected void showMainMenu() {
        AbstractMenu menu = new MainMenu(console, categories, projects);
        menu.show();
        menu.doAction(menu.readUserFeedback());
    }

    protected void showCategoriesMenu() {
        AbstractMenu menu = new CategoryMenu(console, categories, projects);
        menu.show();
        menu.doAction(menu.readUserFeedback());
    }

    protected void showProjectsMenu(int choice) {
        showInput(menuElements[choice]);
        AbstractMenu projectMenu = new ProjectMenu(console, this.categories, this.projects,
                projects.getByCategory(this.categories.get(choice - MENU_SHIFT)));
        projectMenu.show();
        projectMenu.doAction(projectMenu.readUserFeedback());
    }


    protected void showProjectDetailsMenu(int choice) {
        showInput(menuElements[choice]);
        Project project = this.projects.get(choice - MENU_SHIFT);
        AbstractMenu projectDetailsMenu = new ProjectDetailsMenu(console, categories, projects, project);
        projectDetailsMenu.show();
        projectDetailsMenu.doAction(projectDetailsMenu.readUserFeedback());
    }

    private void showInput(MenuElement menuElement) {
        console.write(">> " + menuElement.toString());
    }
}
