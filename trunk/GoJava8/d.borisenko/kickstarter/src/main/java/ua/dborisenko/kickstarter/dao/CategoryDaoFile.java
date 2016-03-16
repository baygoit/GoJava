package ua.dborisenko.kickstarter.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDaoFile extends CategoryDaoMemory implements CategoryDao {
    private static final String ENTITY_SEPARATOR = "#";
    private String categoriesFileName = "./src/main/resources/categories.txt";
    private String projectsFileName = "./src/main/resources/projects.txt";
    private String questionsFileName = "./src/main/resources/questions.txt";
    private String investmentsFileName = "./src/main/resources/investments.txt";
    private String rewardsFileName = "./src/main/resources/rewards.txt";

    public void setCategoriesFileName(String fileName) {
        this.categoriesFileName = fileName;
    }

    public void setProjectsFileName(String fileName) {
        this.projectsFileName = fileName;
    }

    public void setQuestionsFileName(String fileName) {
        this.questionsFileName = fileName;
    }

    public void setInvestmentsFileName(String fileName) {
        this.investmentsFileName = fileName;
    }

    public void setRewardsFileName(String fileName) {
        this.rewardsFileName = fileName;
    }

    @Override
    public void fillData() {
        fillCategories();
        fillProjects();
        fillQuestions();
        fillInvestments();
        fillRewards();
    }

    void fillQuestions() {
        try (BufferedReader is = new BufferedReader(new FileReader(questionsFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] questionParts = line.split(ENTITY_SEPARATOR);
                Question question = new Question();
                question.setId(Integer.valueOf(questionParts[0]));
                question.setRequest(questionParts[2]);
                question.setReply(questionParts[3]);
                for (Category category : categories) {
                    for (Project project : category.getProjects()) {
                        if (Integer.valueOf(questionParts[1]).equals(project.getId())) {
                            project.addQuestion(question);
                        }
                    }
                }
            }
        } catch (IOException e) {
            categories.clear();
            throw new IllegalStateException("Cannot read questions from file");
        }
    }

    void fillInvestments() {
        try (BufferedReader is = new BufferedReader(new FileReader(investmentsFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] investmentParts = line.split(ENTITY_SEPARATOR);
                Investment investment = new Investment();
                investment.setId(Integer.valueOf(investmentParts[0]));
                investment.setCardHolderName(investmentParts[2]);
                investment.setCardNumber(investmentParts[3]);
                investment.setAmount(Integer.valueOf(investmentParts[4]));
                for (Category category : categories) {
                    for (Project project : category.getProjects()) {
                        if (Integer.valueOf(investmentParts[1]).equals(project.getId())) {
                            project.addInvestment(investment);
                        }
                    }
                }
            }
        } catch (IOException e) {
            categories.clear();
            throw new IllegalStateException("Cannot read questions from file");
        }
    }

    void fillRewards() {
        try (BufferedReader is = new BufferedReader(new FileReader(rewardsFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] rewardParts = line.split(ENTITY_SEPARATOR);
                Reward reward = new Reward();
                reward.setId(Integer.valueOf(rewardParts[0]));
                reward.setAmount(Integer.valueOf(rewardParts[2]));
                reward.setDescription(rewardParts[3]);
                for (Category category : categories) {
                    for (Project project : category.getProjects()) {
                        if (Integer.valueOf(rewardParts[1]).equals(project.getId())) {
                            project.addReward(reward);
                        }
                    }
                }
            }
        } catch (IOException e) {
            categories.clear();
            throw new IllegalStateException("Cannot read rewards from file");
        }
    }

    void fillProjects() {
        try (BufferedReader is = new BufferedReader(new FileReader(projectsFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] projectParts = line.split(ENTITY_SEPARATOR);
                Project project = new Project();
                project.setId(Integer.valueOf(projectParts[0]));
                project.setName(projectParts[2]);
                project.setDescription(projectParts[3]);
                project.setRequiredSum(Integer.valueOf(projectParts[4]));
                project.setDaysLeft(Integer.valueOf(projectParts[5]));
                project.setHistory(projectParts[6]);
                project.setVideoUrl(projectParts[7]);
                for (Category category : categories) {
                    if (Integer.valueOf(projectParts[1]).equals(category.getId())) {
                        category.addProject(project);
                    }
                }
            }
        } catch (IOException e) {
            categories.clear();
            throw new IllegalStateException("Cannot read projects from file");
        }
    }

    void fillCategories() {
        try (BufferedReader is = new BufferedReader(new FileReader(categoriesFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] categoryParts = line.split(ENTITY_SEPARATOR);
                Category category = new Category();
                category.setId(Integer.valueOf(categoryParts[0]));
                category.setName(categoryParts[1]);
                categories.add(category);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read categories from file");
        }
    }
}
