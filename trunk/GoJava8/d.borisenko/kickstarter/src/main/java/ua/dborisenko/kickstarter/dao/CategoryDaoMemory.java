package ua.dborisenko.kickstarter.dao;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

public class CategoryDaoMemory extends CategoryDao {
    private static int projectIdGenerator = 1;
    private static int categoryIdGenerator = 1;

    private int getProjectId() {
        return (projectIdGenerator++);
    }

    private int getCategoryId() {
        return (categoryIdGenerator++);
    }

    private Project makeProject(String name, String description, String history, int requiredSum, int collectedSum,
            int daysLeft, String videoURL, String rewardInfo) {
        Project project = new Project();
        project.setId(getProjectId());
        project.setName(name);
        project.setDescription(description);
        project.setHistory(history);
        project.setRequiredSum(requiredSum);
        project.setDaysLeft(daysLeft);
        project.setVideoUrl(videoURL);
        project.setRewardInfo(rewardInfo);
        return project;
    }

    private Category makeCategory(String name) {
        Category category = new Category();
        category.setId(getCategoryId());
        category.setName(name);
        return category;
    }

    public void fillCategories() {
        categories.add(0, makeCategory("Sport"));
        categories.get(0).addProject(makeProject("Cube soccer ball", "Test description", "Test history", 4000, 2300, 12,
                "http://freakysoccer.biz", "No reward using memory mode. Just donate!"));
        categories.get(0).addProject(makeProject("New stadium building", "Test description", "Test history", 23000000,
                0, 360, "http://arenakyiv.ua", "No reward using memory mode. Just donate!"));
        categories.add(1, makeCategory("Space investigation"));
        categories.get(1).addProject(makeProject("Mars colonization", "Test description", "Test history", 100000, 5600,
                1260, "http://apple_mars.narod.ru", "No reward using memory mode. Just donate!"));
        categories.get(1).addProject(makeProject("Changing the Earth orbit", "Test description", "Test history ", 500,
                10, 7, "http://xxx-super-movie-without-registration.to", "No reward using memory mode. Just donate!"));
        categories.add(2, makeCategory("Game development"));
        categories.get(2).addProject(makeProject("Tetris 4D", "Test description", "Test history", 54000, 470, 65,
                "http://4drealms.com/tetris_forever", "No reward using memory mode. Just donate!"));
        categories.get(2).addProject(makeProject("Carmageddon 5 mobile", "Test description", "Test history", 741652,
                6500, 115, "http://series40.com/games/carmageddon", "No reward using memory mode. Just donate!"));
    }
}
