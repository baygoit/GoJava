package dao;

import model.Category;
import model.Project;
import model.Quote;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 16:12
 * @version: 1.0
 */
public interface LoadingData {

    public List<Category> getCategoryList();
    public Category getCategoryByID(int categoryId);
    public List<Project> getListOfProjectByCategoryID(int categoryId);
    public List<Quote> getQuoteList();
    public Project getProjectByID(int projectId);

    public void updateUserQuestionAnswerOfProject(Project project);
    public void updateDemoLinkOfProject(Project project);
    public void updateHistoryOfProject(Project project);
    public void updateTermsOfProject(Project project);
    public <T> void setInfoOfProject(Project project, String field, T value);

    public Project.Terms getTermByID(int projectId, int termId);

    public void setQuestionAnswerOfProject(Project project, String description, String user);
}
