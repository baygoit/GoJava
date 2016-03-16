package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

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
        addContentString("Questions and answers:");
        addContentString(SOLID_LINE);
        for (Question question : project.getQuestions()) {
            addContentString("Q: " + question.getRequest());
            if (question.getReply() != null) {
                addContentString("A: " + question.getReply());
            }
        }
        addContentString(SOLID_LINE);
        addContentString("Please select action:");
        addContentString("1: Invest into the project");
        addContentString("2: Ask a question");
        addContentString("0: Return");
    }
}
