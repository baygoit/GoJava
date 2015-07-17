package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectView extends BaseView {

    public void render(ProjectModel model) {
        getOutput().writeLine(String.format("Project name: %s", model.getName()));
        getOutput().writeLine(String.format("Short Description: %s", model.getShortDescription()));
        getOutput().writeLine(String.format("Demo link: %s", model.getDemoLink()));
        getOutput().writeLine(String.format("Balance: %s; Goal: %s; Time left: %s", getMoney(model.getBalance()), getMoney(model.getGoal()), getDiffDate(model.getDeadlineDate(), new Date())));
        if (model.isFaqExists()) {
            getOutput().writeLine("FAQ:");
            List<Faq> faqs = model.getFaqs();
            Faq faq;
            for (int counter = 0; counter < faqs.size(); counter++) {
                faq = faqs.get(counter);
                getOutput().writeLine(String.format("  %s. <%s>", counter + 1, faq.getQuestion()));
                getOutput().writeLine(String.format("      %s", faq.getAnswer()));
            }
        }
        if (model.isProjectEvenExists()) {
            getOutput().writeLine("Project events:");
            List<ProjectEvent> projectEvents = model.getProjectEvent();
            for (ProjectEvent projectEvent : projectEvents) {
                getOutput().writeLine(String.format("  %s: %s", getDate(projectEvent.getEventDate()), projectEvent.getMessage()));
            }
        }
        getOutput().writeLine("Actions:");
        getOutput().writeLine("[1]. Ask a question");
        getOutput().writeLine("[2]. Invest");
        getOutput().writeLine(CHOICE_MESSAGE);
    }
}
