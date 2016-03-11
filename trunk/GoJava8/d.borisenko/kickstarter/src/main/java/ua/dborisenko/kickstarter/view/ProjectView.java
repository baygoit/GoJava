package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;

public class ProjectView extends View {

    public ProjectView(Project project, String categoryName) {
        addContentString(HEADER_BLOCK);
        addContentString("Project " + project.getName());
        addContentString(SOLID_LINE);
        addContentString("Category:        " + categoryName);
        addContentString("Description:     " + project.getDescription());
        addContentString("Required sum:    " + project.getRequiredSum());
        addContentString("Collected sum:   " + project.getCollectedSum());
        addContentString("History:         " + project.getHistory());
        addContentString("Video link:      " + project.getVideoUrl());
        addContentString("Discussion link: " + project.getDiscussionUrl());
        addContentString(SOLID_LINE);
        addContentString("Enter \"0\" to return:");
    }
}
