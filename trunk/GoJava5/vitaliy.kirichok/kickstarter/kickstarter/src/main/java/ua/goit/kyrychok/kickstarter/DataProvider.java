package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.Reward;

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

    public void incProjectBalance(int categoryIndex, int projectIndex, Integer amount) {
        Project project = categories.get(categoryIndex).getProjects().get(projectIndex);
        project.setBalance(project.getBalance() + amount);
    }

    public void addReward(int categoryIndex, int projectIndex, Reward reward) {
        categories.get(categoryIndex).getProjects().get(projectIndex).addReward(reward);
    }

    public List<Reward> getRewards(int categoryIndex, int projectIndex) {
        return categories.get(categoryIndex).getProjects().get(projectIndex).getRewards();
    }

    public Project getProject(int id) {
        return categories.get(0).getProjects().get(0);
    }

    public void addFaq(int projectId, Faq faq) {
        categories.get(0).getProjects().get(projectId).addFaq(faq);
    }

    public List<Reward> getRewards(int projectIndex) {
        return categories.get(0).getProjects().get(projectIndex).getRewards();
    }

    public void incProjectBalance(int projectIndex, Integer amount) {
        Project project = getProject(projectIndex);
        project.setBalance(project.getBalance() + amount);
    }

    public Reward getReward(int id) {
        return categories.get(0).getProjects().get(0).getRewards().get(id);
    }
}
