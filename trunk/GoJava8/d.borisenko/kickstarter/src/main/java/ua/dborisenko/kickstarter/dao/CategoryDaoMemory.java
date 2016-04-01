package ua.dborisenko.kickstarter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDaoMemory implements CategoryDao {
    List<Category> categories = new ArrayList<Category>();
    List<Map<Integer, Question>> questions = new ArrayList<>();
    List<Map<Integer, Reward>> rewards = new ArrayList<>();
    private static int projectIdGenerator = 1;
    private static int categoryIdGenerator = 1;
    private static int rewardIdGenerator = 1;

    @Override
    public Category getCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found.");
    }

    @Override
    public Project getProjectById(int id) {
        for (Category category : categories) {
            for (Project project : category.getProjects()) {
                if (project.getId() == id) {
                    return project;
                }
            }
        }
        throw new IllegalArgumentException("Project not found.");
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void addInvestment(int projectId, Investment investment) {
        getProjectById(projectId).addInvestment(investment);
    }

    @Override
    public void addQuestion(int projectId, Question question) {
        getProjectById(projectId).addQuestion(question);
    }

    @Override
    public void getQuestions(Project project) {
        for (Map<Integer, Question> questionMap : questions) {
            if (questionMap.containsKey(project.getId())) {
                project.addQuestion(questionMap.get(project.getId()));
            }
        }
    }

    @Override
    public void getRewards(Project project) {
        project.getRewards().clear();
        for (Map<Integer, Reward> rewardMap : rewards) {
            if (rewardMap.containsKey(project.getId())) {
                project.addReward(rewardMap.get(project.getId()));
            }
        }
    }

    private int getProjectId() {
        return (projectIdGenerator++);
    }

    private int getCategoryId() {
        return (categoryIdGenerator++);
    }

    private int getRewardId() {
        return (rewardIdGenerator++);
    }

    private Project makeProject(String name, String description, String history, int requiredSum, int collectedSum,
            int daysLeft, String videoURL) {
        Project project = new Project();
        project.setId(getProjectId());
        project.setName(name);
        project.setDescription(description);
        project.setHistory(history);
        project.setRequiredSum(requiredSum);
        project.setDaysLeft(daysLeft);
        project.setVideoUrl(videoURL);
        return project;
    }

    private Category makeCategory(String name) {
        Category category = new Category();
        category.setId(getCategoryId());
        category.setName(name);
        return category;
    }

    public void fillData() {
        fillCategories();
        fillProjects();
        fillQuestions();
        fillRewards();
    }

    private void fillCategories() {
        categories.add(0, makeCategory("Sport"));
        categories.add(1, makeCategory("Space investigation"));
        categories.add(2, makeCategory("Game development"));
    }

    private void fillProjects() {
        Project project = makeProject("Cube soccer ball", "Test description", "Test history", 4000, 2300, 12,
                "http://freakysoccer.biz");
        Reward reward = new Reward();
        project.addReward(reward);
        categories.get(0).addProject(makeProject("Cube soccer ball", "Test description", "Test history", 4000, 2300, 12,
                "http://freakysoccer.biz"));
        categories.get(0).addProject(makeProject("New stadium building", "Test description", "Test history", 23000000,
                0, 360, "http://arenakyiv.ua"));
        categories.get(1).addProject(makeProject("Mars colonization", "Test description", "Test history", 100000, 5600,
                1260, "http://apple_mars.narod.ru"));
        categories.get(1).addProject(makeProject("Changing the Earth orbit", "Test description", "Test history ", 500,
                10, 7, "http://xxx-super-movie-without-registration.to"));
        categories.get(2).addProject(makeProject("Tetris 4D", "Test description", "Test history", 54000, 470, 65,
                "http://4drealms.com/tetris_forever"));
        categories.get(2).addProject(makeProject("Carmageddon 5 mobile", "Test description", "Test history", 741652,
                6500, 115, "http://series40.com/games/carmageddon"));
    }

    private void fillRewards() {
        for (int i = 1; i <= 6; i++) {
            Reward reward = new Reward();
            reward.setId(getRewardId());
            reward.setAmount(100);
            reward.setDescription("T-shirt");
            rewards.add(new HashMap<>());
            rewards.get(i - 1).put(i, reward);
        }
    }

    private void fillQuestions() {
        for (int i = 1; i <= 6; i++) {
            Question question = new Question();
            question.setId(i);
            question.setRequest("Test question");
            question.setReply("Test answer");
            questions.add(new HashMap<>());
            questions.get(i - 1).put(i, question);
        }
    }

    @Override
    public Category getCategoryByProjectId(int id) {
        for (Category category : categories) {
            for (Project project : category.getProjects()) {
                if (project.getId() == id) {
                    return category;
                }
            }
        }
        throw new IllegalArgumentException("Project not found.");
    }
}
