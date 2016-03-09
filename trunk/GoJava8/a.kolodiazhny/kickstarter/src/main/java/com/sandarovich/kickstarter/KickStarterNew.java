package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.category.Category;
import com.sandarovich.kickstarter.category.CategorySource;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarterNew {
    private IO console;
    private QuotaSource quotaSource;
    private CategorySource categorySource;

    KickStarterNew(IO console) {
        this.console = console;
    }

    public void start() {
        init();
        showApplicationTitle();
        showQuota();
        showAllCategories();
        Category category = readCategory();
        showCategory(category);
    }

    private void showCategory(Category category) {
        console.write(category.toString());
    }

    private Category readCategory() {
        String readed = console.read();
        if (!categorySource.isValidCategory(readed)) {
            console.write(">> Option is not found. Please try again");
            return readCategory();
        }
        return categorySource.getCategoryById(Integer.parseInt(readed));
    }

    private void init() {
        quotaSource = new QuotaSource();
        quotaSource.init();
        categorySource = new CategorySource();
        categorySource.init();
    }

    private void showAllCategories() {
        console.write(categorySource.getAllCategories());
    }

    private void showQuota() {
        console.write(quotaSource.getRandomQuota());
    }

    private void showApplicationTitle() {
        console.write(getApplicationTitle());
    }

    private String getApplicationTitle() {
        StringBuilder result = new StringBuilder();
        result.append("=======================================\n");
        result.append("     Kickstarter emulator\n");
        result.append("     by O.Kolodiazhny 2016\n");
        result.append("=======================================");
        return result.toString();
    }

}
