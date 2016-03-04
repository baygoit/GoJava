package ua.dborisenko.kickstarter;

import java.util.List;

public class ViewProjectCategories extends View {
    private String dailyPhrase;
    private List<ProjectCategory> categories;

    public ViewProjectCategories(List<ProjectCategory> categories, String dailyPhrase) {
        this.categories = categories;
        this.dailyPhrase = dailyPhrase;
    }

    @Override
    public String generate() {
        drawHeaderBlock();
        System.out.println("*** The phrase of the day: ***");
        System.out.println(dailyPhrase);
        drawDivider();
        System.out.println("Project categories list");
        drawDivider();
        for (int i = 0; i < this.categories.size(); i++) {
            System.out.println((i + 1) + ": " + categories.get(i).getName());
        }
        drawDivider();
        System.out.println("Enter category number or select \"0\" to exit:");
        return readInput();
    }
}
