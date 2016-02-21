package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.category.CategoriesBuilder;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.project.ProjectBuilder;
import com.sandarovich.kickstarter.project.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016
 *         KickStarter analog.
 */

public class KickStarter {

    public static final String APPLICATION_VERSION = "0.0.5";
    private IO console;

    public KickStarter(IO console) {
        this.console = console;
    }

    public void start() {
        new Intro(console).show();
        Categories categories = setupCategories();
        Projects projects = setupProjects(categories);
        AbstractMenu menu = new MainMenu(console, categories, projects);
        menu.show();
        menu.doAction(menu.readUserFeedback());

    }

    private Projects setupProjects(Categories categories) {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(1)
                .andCategory(categories.get(0))
                .andName("USB TOY   ")
                .andDescription("Not Ordinary gameplay ")
                .build();
        builder.forId(2)
                .andCategory(categories.get(0))
                .andName("Power Bank")
                .andDescription("Unique technology ")
                .build();
        builder.forId(3)
                .andCategory(categories.get(0))
                .andName("Robot Frodo")
                .andDescription("Fast and Smart")
                .build();
        return builder.getProjects();
    }

    private Categories setupCategories() {
        List<String> categories = new ArrayList<String>();
        categories.add("IT");
        categories.add("Tourism");
        categories.add("Garden");
        CategoriesBuilder builder = new CategoriesBuilder();
        builder.createAll(categories);
        return builder.get();
    }
}
