package ua.dborisenko.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.Category;
import ua.dborisenko.kickstarter.Project;

public class CategoryDao {

    public static List<Category> hardCodedCategories = new ArrayList<Category>();
    private static int idProjectGenerator = 1;
    private static int idCategoryGenerator = 1;

    public void add(Category category) {
        hardCodedCategories.add(category);
    }

    public Category getByName(String name) {
        for (Category category : hardCodedCategories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        Category category = new Category();
        return category;
    }

    public Category getById(int id) {
        for (Category category : hardCodedCategories) {
            if (category.getId() == id) {
                return category;
            }
        }
        Category category = new Category();
        return category;
    }

    public Category getByListNumber(int number) {
        return hardCodedCategories.get(number);
    }
    
    public List<Category> getAll() {
        return hardCodedCategories;
    }

    private int getProjectId() {
        return (idProjectGenerator++);
    }

    private int getCategoryId() {
        return (idCategoryGenerator++);
    }

    private Category makeCategory(String name) {
        Category category = new Category();
        category.setId(getCategoryId());
        category.setName(name);
        return category;
    }

    private Project makeProject(String name, String description, String history, int requiredSum, int collectedSum,
            int daysLeft, String videoURL, String discussionURL) {
        Project project = new Project();
        project.setId(getProjectId());
        project.setName(name);
        project.setDescription(description);
        project.setHistory(history);
        project.setRequiredSum(requiredSum);
        project.setCollectedSum(collectedSum);
        project.setDaysLeft(daysLeft);
        project.setVideoUrl(videoURL);
        project.setDiscussionUrl(discussionURL);
        return project;
    }
    
    public void fillHardcodedCategories() {
        hardCodedCategories.add(0, makeCategory("Sport"));
        hardCodedCategories.get(0).addProject(makeProject("Cube soccer ball", "Test description", "Test history", 4000,
                2300, 12, "http://freakysoccer.biz", "Questions and answers are not implemented yet"));
        hardCodedCategories.get(0).addProject(makeProject("New stadium building", "Test description", "Test history",
                23000000, 0, 360, "http://arenakyiv.ua", "Questions and answers are not implemented yet"));
        hardCodedCategories.add(1, makeCategory("Space investigation"));
        hardCodedCategories.get(1).addProject(makeProject("Mars colonization", "Test description", "Test history",
                100000, 5600, 1260, "http://apple_mars.narod.ru", "Questions and answers are not implemented yet"));
        hardCodedCategories.get(1).addProject(makeProject("Changing the Earth orbit", "Test description", "Test history ",
                500, 10, 7, "http://xxx-super-movie-without-registration.to",
                        "Questions and answers are not implemented yet"));
        hardCodedCategories.add(2, makeCategory("Game development"));
        hardCodedCategories.get(2).addProject(makeProject("Tetris 4D", "Test description", "Test history", 54000, 470, 65,
                "http://4drealms.com/tetris_forever", "Questions and answers are not implemented yet"));
        hardCodedCategories.get(2).addProject(makeProject("Carmageddon 5 mobile", "Test description", "Test history", 741652, 6500, 115,
                "http://series40.com/games/carmageddon", "Questions and answers are not implemented yet"));
    }
}
