package ua.dborisenko.kickstarter;

public class ViewProject extends View {
    private Project project;

    public ViewProject(Project currentProject) {
        this.project = currentProject;
    }

    @Override
    public String generate() {
        drawHeaderBlock();
        System.out.println("Project " + project.getName());
        drawDivider();
        System.out.println("Category:        " + project.getCategoryName());
        System.out.println("Description:     " + project.getDescription());
        System.out.println("Required sum:    " + project.getRequiredSum());
        System.out.println("Collected sum:   " + project.getCollectedSum());
        System.out.println("History:         " + project.getHistory());
        System.out.println("Video link:      " + project.getVideoUrl());
        System.out.println("Discussion link: " + project.getDiscussionUrl());
        drawDivider();
        System.out.println("Enter \"0\" to return:");
        return readInput();
    }
}
