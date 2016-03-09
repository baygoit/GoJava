package ua.dborisenko.kickstarter;

public class ViewProject extends View {
    private Project project;
    private String categoryName;

    public ViewProject(Project currentProject, String currentCategoryName) {
        project = currentProject;
        categoryName = currentCategoryName;
    }

    @Override
    public void generate() {
        addContentString(headerBlock);
        addContentString("Project " + project.getName());
        addContentString(solidLine);
        addContentString("Category:        " + categoryName);
        addContentString("Description:     " + project.getDescription());
        addContentString("Required sum:    " + project.getRequiredSum());
        addContentString("Collected sum:   " + project.getCollectedSum());
        addContentString("History:         " + project.getHistory());
        addContentString("Video link:      " + project.getVideoUrl());
        addContentString("Discussion link: " + project.getDiscussionUrl());
        addContentString(solidLine);
        addContentString("Enter \"0\" to return:");
        ioHandler.write(content.toString());
     }
}
