package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectView {
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    public void render(ProjectModel model) {
        output.writeLine(String.format("Project name: %s", model.getName()));
        output.writeLine(String.format("Short Description: %s", model.getShortDescription()));
        output.writeLine(String.format("Demo link: %s", model.getDemoLink()));
        output.writeLine(String.format("Goal: %s", getMoney(model.getGoal())));
        output.writeLine(String.format("Balance: %s", getMoney(model.getBalance())));
        output.writeLine(String.format("Time left: %s", getDiffDate(model.getDeadlineDate(), new Date())));
        if (model.isFaqExists()) {
            output.writeLine("FAQ:");
            List<Faq> faqs = model.getFaqs();
            Faq faq;
            for (int counter = 0; counter < faqs.size(); counter++) {
                faq = faqs.get(counter);
                output.writeLine(String.format("  %s. [%s]", counter + 1, faq.getQuestion()));
                output.writeLine(String.format("      %s", faq.getAnswer()));
            }
        }
        if (model.isProjectEvenExists()) {
            output.writeLine("Project events:");
            List<ProjectEvent> projectEvents = model.getProjectEvent();
            for (ProjectEvent projectEvent : projectEvents) {
                output.writeLine(String.format("  %s: %s", getDate(projectEvent.getEventDate()), projectEvent.getMessage()));
            }
        }
        output.writeLine(CHOICE_MESSAGE);
    }
}
