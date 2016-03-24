package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public class ProjectView extends View {

    public static final String INPUT_TO_RETURN = "0";
    public static final String INPUT_TO_INVEST = "1";
    public static final String INPUT_TO_QUESTION = "2";

    public void showContent(Project project, String categoryName) {
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
        addContentString(INPUT_TO_INVEST + ": Invest into the project");
        addContentString(INPUT_TO_QUESTION + ": Ask a question");
        addContentString(INPUT_TO_RETURN + ": Return");
        ioHandler.writeMessage(content.toString());
    }

    public void showMsgEnterQuestion() {
        showMessage("Enter your question:");
    }
}
