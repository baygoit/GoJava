package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectView extends BaseView {

    public void render(ProjectModel model) {
        writeLine(String.format("Project name: %s", model.getName()));
        writeLineWithParam("Short Description: %s", model.getShortDescription());
        writeLineWithParam("Demo link: %s", model.getDemoLink());
        writeLine(String.format("Balance: %s; Goal: %s; Time left: %s", getMoney(model.getBalance()), getMoney(model.getGoal()), getDiffDate(model.getDeadlineDate(), new Date())));
        if (model.isFaqExists()) {
            writeLine("FAQ:");
            List<Faq> faqs = model.getFaqs();
            Faq faq;
            for (int counter = 0; counter < faqs.size(); counter++) {
                faq = faqs.get(counter);
                writeLine(String.format("  %s. <%s>", counter + 1, faq.getQuestion()));
                writeLineWithParam("      %s", faq.getAnswer());
            }
        }
        if (model.isProjectEvenExists()) {
            writeLine("Project events:");
            List<ProjectEvent> projectEvents = model.getProjectEvent();
            for (ProjectEvent projectEvent : projectEvents) {
                writeLine(String.format("  %s: %s", getDate(projectEvent.getEventDate()), projectEvent.getMessage()));
            }
        }
        writeLine("Actions:");
        writeLine("[1]. Ask a question");
        writeLine("[2]. Donate");
        writeLine(CHOICE_MESSAGE);
    }
}
