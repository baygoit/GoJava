package ua.dborisenko.kickstarter.view;

import java.io.PrintWriter;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public class ProjectView extends View {

    public void show(PrintWriter writer, Project project, Category category) {
        this.pageTitle = project.getName();
        addContentString(getHeaderBlock());
        addContentString("<p>Project details:<br/><table>");
        addContentString("<tr><td>Description:</td><td>" + project.getDescription() + "</td></tr>");
        addContentString("<tr><td>Required sum:</td><td>" + project.getRequiredSum() + "</td></tr>");
        addContentString("<tr><td>Collected sum:</td><td>" + project.getCollectedSum() + "</td></tr>");
        addContentString("<tr><td>History:</td><td>" + project.getHistory() + "</td></tr>");
        addContentString("<tr><td>Video link:</td><td>" + project.getVideoUrl() + "</td></tr>");
        addContentString("</table>");
        addContentString("Questions and answers:<hr>");
        for (Question question : project.getQuestions()) {
            addContentString("Q: " + question.getRequest() + "<br/>");
            if (question.getReply() != null) {
                addContentString("A: " + question.getReply() + "<br/>");
            }
        }
        addContentString("<hr>");
        addContentString("<a href='?page=investment&id=" + project.getId() + "'>Invest into the project</a><br/>");
        addContentString("Ask a question<br/>");
        // addContentString("<form method='post'
        // action='/kickstarter/?page=category&id=1'>");
        addContentString("<form name='add_question' method='POST' action='' accept-charset='utf-8'>");
        addContentString("<input type='hidden' name='requested_action' value='ADD_QUESTION'>");
        addContentString("<input type='hidden' name='project_id' value='" + project.getId() + "'>");
        addContentString("<input type='textarea' maxlength='1024' name='question_request' cols='200' rows='5'>");
        addContentString("<input type='submit' value='Send'>");
        addContentString("</form>");
        addContentString("<a href='?page=category&id=" + category.getId() + "'>Return to the list of projects</a>");
        addContentString(getFooterBlock());
        writer.println(content.toString());
    }
}
