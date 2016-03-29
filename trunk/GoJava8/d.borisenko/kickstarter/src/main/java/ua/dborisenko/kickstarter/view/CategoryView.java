package ua.dborisenko.kickstarter.view;

import java.io.PrintWriter;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

public class CategoryView extends View {

    public void show(PrintWriter writer, Category category) {
        this.pageTitle = category.getName();
        addContentString(getHeaderBlock());
        addContentString("<p>Choose the project:</p>");
        addContentString("<ul>");
        for (Project project : category.getProjects()) {
            addContentString("<li><a href='?page=project&id=" + project.getId() + "'>" + project.getName()
                    + " (collected: " + project.getCollectedSum() + "/" + project.getRequiredSum() + ")</a><br/>");
            addContentString(project.getDescription() + "</li>");
        }
        addContentString("</ul>");
        addContentString("<a href='?page=categories'>Return to the main page</a>");
        addContentString(getFooterBlock());
        writer.println(content.toString());
    }
}
