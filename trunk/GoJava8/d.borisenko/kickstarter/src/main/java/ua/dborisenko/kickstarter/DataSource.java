package ua.dborisenko.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Project> allProjects = new ArrayList<Project>();
    public static List<ProjectCategory> allProjectCategories = new ArrayList<ProjectCategory>();
    public static List<String> allDailyPhrases = new ArrayList<String>();
    private static int idProjectGenerator = 1;
    private static int idProjectCategoryGenerator = 1;

    private static int getProjectId() {
        return (idProjectGenerator++);
    }

    private static int getProjectCategoryId() {
        return (idProjectCategoryGenerator++);
    }

    public static void fillAllDailyPhrases() {
        allDailyPhrases.add("The best preparation for tomorrow is doing your best today.");
        allDailyPhrases.add("Nothing is impossible, the word itself says 'I'm possible'!");
        allDailyPhrases.add("If opportunity doesn't knock, build a door.");
        allDailyPhrases
                .add("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.");
        allDailyPhrases.add("We do what we must because we can. For the good of all of us.");
        allDailyPhrases.add("Success is simple. Do what's right, the right way, at the right time.");
        allDailyPhrases.add("Victory has a thousand fathers, but defeat is an orphan.");
        allDailyPhrases.add("In order to attain the impossible, one must attempt the absurd.");
    }

    public static void fillAllProjectCategories() {
        makeAnotherProjectCategory("Sport");
        makeAnotherProjectCategory("Space investigation");
        makeAnotherProjectCategory("Game development");
    }

    private static void makeAnotherProjectCategory(String name) {
        ProjectCategory category = new ProjectCategory();
        category.setId(getProjectCategoryId());
        category.setName(name);
        DataSourceProjectCategory.add(category);
    };

    private static void makeAnotherProject(String categoryName, String name, String description, String history,
            int requiredSum, int collectedSum, int daysLeft, String videoURL, String discussionURL) {
        Project project = new Project();
        project.setId(getProjectId());
        project.setCategory(DataSourceProjectCategory.getByName(categoryName));
        project.setName(name);
        project.setDescription(description);
        project.setHistory(history);
        project.setRequiredSum(requiredSum);
        project.setCollectedSum(collectedSum);
        project.setDaysLeft(daysLeft);
        project.setVideoUrl(videoURL);
        project.setDiscussionUrl(discussionURL);
        DataSourceProject.add(project);
    };

    public static void fillAllProjects() {
        makeAnotherProject("Sport", "Cube soccer ball", "Test description", "Test history", 4000, 2300, 12,
                "http://freakysoccer.biz", "Questions and answers are not implemented yet");
        makeAnotherProject("Sport", "New stadium building", "Test description", "Test history", 23000000, 0, 360,
                "http://arenakyiv.ua", "Questions and answers are not implemented yet");
        makeAnotherProject("Space investigation", "Mars colonization", "Test description", "Test history", 100000, 5600,
                1260, "http://apple_mars.narod.ru", "Questions and answers are not implemented yet");
        makeAnotherProject("Space investigation", "Changing the Earth orbit", "Test description", "Test history ", 500,
                10, 7, "http://xxx-super-movie-without-registration.to",
                "Questions and answers are not implemented yet");
        makeAnotherProject("Game development", "Tetris 4D", "Test description", "Test history", 54000, 470, 65,
                "http://4drealms.com/tetris_forever", "Questions and answers are not implemented yet");
        makeAnotherProject("Game development", "Carmageddon 5 mobile", "Test description", "Test history", 741652, 6500,
                115, "http://series40.com/games/carmageddon", "Questions and answers are not implemented yet");
    }
}
