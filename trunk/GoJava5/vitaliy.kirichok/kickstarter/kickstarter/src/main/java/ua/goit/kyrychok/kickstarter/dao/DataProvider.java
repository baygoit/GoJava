package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

public interface DataProvider {
    String getWelcomeMessage();

    List<Category> getCategories();

    Category getCategory(int id);

    Project getProject(int id);

    void addFaq(int projectId, Faq faq);

    List<Reward> getRewards(int projectId);

    void setProjectBalance(int projectId, int amount);

    int getProjectBalance(int projectId);

    Reward getReward(int id);
}
