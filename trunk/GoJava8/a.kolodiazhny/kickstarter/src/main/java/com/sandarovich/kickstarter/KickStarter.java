package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.category.CategorySource;
import com.sandarovich.kickstarter.category.CategorySourceBuilder;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.project.ProjectBuilder;
import com.sandarovich.kickstarter.project.ProjectSource;

import java.util.ArrayList;
import java.util.List;

/**
 *    KickStarter analog.
 *
 */

public class KickStarter {

    public static final String APPLICATION_VERSION = "0.0.5";

    private IO console;

    public KickStarter(IO console) {
        this.console = console;
    }

    public void start() {
        showApplicationAuthor();
        showQuote();
        CategorySource categories = setupAllCategories();
        ProjectSource projects = setupAllProjects(categories);
        AbstractMenu menu = new MainMenu(console, categories, projects);
        menu.show();
        menu.performAction(menu.getUserChoice());
    }

    private ProjectSource setupAllProjects(CategorySource categories) {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(101)
                .andCategory(categories.get(0))
                .andName("USB TOY   ")
                .andDescription("Not Ordinary gameplay ")
                .build();
        builder.forId(102)
                .andCategory(categories.get(0))
                .andName("Power Bank")
                .andDescription("Unique technology ")
                .build();
        builder.forId(3)
                .andCategory(categories.get(0))
                .andName("Robot Frodo")
                .andDescription("Fast and Smart")
                .build();
        builder.forId(97)
                .andCategory(categories.get(2))
                .andName("Bison grass")
                .andDescription("Power energy from sun")
                .build();
        builder.forId(77)
                .andCategory(categories.get(2))
                .andName("Garfield grass")
                .andDescription("Feel exotic")
                .build();
        builder.forId(5)
                .andCategory(categories.get(1))
                .andName("Super Bag")
                .andDescription("Auto resizable")
                .build();
        return builder.getProjects();
    }

    private CategorySource setupAllCategories() {
        List<String> categories = new ArrayList<String>();
        categories.add("IT");
        categories.add("Tourism");
        categories.add("Garden");
        CategorySourceBuilder builder = new CategorySourceBuilder();
        builder.createAll(categories);
        return builder.get();
    }

    public void showApplicationAuthor() {
        console.write("=======================================");
        console.write("     Kickstarter emulator v." + KickStarter.APPLICATION_VERSION);
        console.write("     by O.Kolodiazhny 2016      ");
        console.write("=======================================");
    }

    public void showQuote() {
        QuotaSource quotaSource = new QuotaSource();
        quotaSource.init();
        console.write(quotaSource.getRandomQuota());
    }
}
