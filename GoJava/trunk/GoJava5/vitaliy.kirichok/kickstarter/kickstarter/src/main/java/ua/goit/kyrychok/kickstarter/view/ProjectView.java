package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectView extends BaseView {

    public ProjectView(Output output) {
        super(output);
    }

    public void render(Project model) {
        writeLine(String.format("Project name: %s", model.getName()));
        writeLineWithParam("Short Description: %s", model.getShortDescription());
        writeLineWithParam("Demo link: %s", model.getDemoLink());
        writeLine(String.format("Balance: %s; Goal: %s; Time left: %s", getMoney(model.getBalance()), getMoney(model.getGoal()), getDiffDate(model.getDeadlineDate(), new Date())));
        List<Faq> faqs = model.getFaqs();
        if (faqs.size() > 0) {
            writeLine("FAQ:");
            Faq faq;
            for (int counter = 0; counter < faqs.size(); counter++) {
                faq = faqs.get(counter);
                writeLine(String.format("  %s. <%s>", counter + 1, faq.getQuestion()));
                writeLineWithParam("      %s", faq.getAnswer());
            }
        }
        List<ProjectEvent> projectEvents = model.getProjectEvents();
        if (projectEvents.size() > 0) {
            writeLine("Project events:");
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
