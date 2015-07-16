package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static final String WELCOME_MESSAGE = "This is HelloMessage";

    private String welcomeMessage = WELCOME_MESSAGE;
    private List<Category> categories;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory(int index) {
        return categories.get(index);
    }

    public Project getProject(int categoryIndex, int projectIndex) {
        return categories.get(categoryIndex).getProjects().get(projectIndex);
    }

    public void addCategory(Category category) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(category);
    }

    public void addFaq(int categoryIndex, int projectIndex, Faq faq) {
        categories.get(categoryIndex).getProjects().get(projectIndex).addFaq(faq);
    }
}
