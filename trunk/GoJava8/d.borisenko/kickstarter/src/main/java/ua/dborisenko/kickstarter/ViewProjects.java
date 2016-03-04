package ua.dborisenko.kickstarter;

import java.util.List;

public class ViewProjects extends View {
    private List<Project> projects;
    private String categoryName;

    public ViewProjects(List<Project> projects, String categoryName) {
        this.projects = projects;
        this.categoryName = categoryName;
    }

    @Override
    public String generate() {
        drawHeaderBlock();
        System.out.println("Category: " + categoryName);
        System.out.println("Projects:");
        drawDivider();
        Project project = new Project();
        for (int i = 0; i < projects.size(); i++) {
            project = projects.get(i);
            System.out.println((i + 1) + ": " + project.getName() + " (collected: 1" + project.getCollectedSum() + "/"
                    + project.getRequiredSum() + ")");
            System.out.println(project.getDescription());
        }
        drawDivider();
        System.out.println("Enter project number or select \"0\" to return:");
        return readInput();
    }
}
