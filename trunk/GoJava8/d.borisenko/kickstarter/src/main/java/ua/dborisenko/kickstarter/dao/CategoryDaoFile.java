package ua.dborisenko.kickstarter.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDaoFile extends CategoryDaoMemory implements CategoryDao {
    private static final String ENTITY_SEPARATOR = "#";
    private String categoriesFileName = "/categories.txt";
    private String projectsFileName = "/projects.txt";
    private String questionsFileName = "/questions.txt";
    private String investmentsFileName = "/investments.txt";
    private String rewardsFileName = "/rewards.txt";

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
        fillInvestments();
    }

    @Override
    public void getQuestions(Project project) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(questionsFileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] questionParts = line.split(ENTITY_SEPARATOR);
                Question question = new Question();
                question.setId(Integer.valueOf(questionParts[0]));
                question.setRequest(questionParts[2]);
                question.setReply(questionParts[3]);
                if (Integer.valueOf(questionParts[1]).equals(project.getId())) {
                    project.addQuestion(question);
                }
            }
        } catch (Exception e) {
            categories.clear();
            throw new IllegalStateException(e);
        }
    }

    void fillInvestments() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(investmentsFileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
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
        } catch (Exception e) {
            categories.clear();
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void getRewards(Project project) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(rewardsFileName)))) {
            String line;
            project.getRewards().clear();
            while ((line = reader.readLine()) != null) {
                String[] rewardParts = line.split(ENTITY_SEPARATOR);
                Reward reward = new Reward();
                reward.setId(Integer.valueOf(rewardParts[0]));
                reward.setAmount(Integer.valueOf(rewardParts[2]));
                reward.setDescription(rewardParts[3]);
                if (Integer.valueOf(rewardParts[1]).equals(project.getId())) {
                    project.addReward(reward);
                }
            }
        } catch (Exception e) {
            categories.clear();
            throw new IllegalStateException(e);
        }
    }

    void fillProjects() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(projectsFileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
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
        } catch (Exception e) {
            categories.clear();
            throw new IllegalStateException(e);
        }
    }

    void fillCategories() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(categoriesFileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] categoryParts = line.split(ENTITY_SEPARATOR);
                Category category = new Category();
                category.setId(Integer.valueOf(categoryParts[0]));
                category.setName(categoryParts[1]);
                categories.add(category);
            }
        } catch (Exception e) {
            categories.clear();
            throw new IllegalStateException(e);
        }
    }
}
