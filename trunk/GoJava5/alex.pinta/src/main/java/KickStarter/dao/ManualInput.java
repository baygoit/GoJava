package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 7:36
 * @version: 1.0
 */
public class ManualInput implements LoadingData{
    private ArrayList<Category> catalogCategory = new ArrayList<Category>();
    private Map<Category, ArrayList<Project>>  mappingCategoryAndProject = new HashMap<>();

    @Override
    public void load(){
        int idCounterOfCategory = 0;
        int idCounterOfProject = 0;

        ArrayList<Project> projectOfCategory = new ArrayList<Project>();
        Category elementCategory = new Category(++idCounterOfCategory, "List of category");
//        ++idCounterOfCategory;
        catalogCategory.add(elementCategory);
        mappingCategoryAndProject.put(elementCategory, projectOfCategory);
        projectOfCategory = new ArrayList<Project>();
        elementCategory = new Category(++idCounterOfCategory, "Education");
        catalogCategory.add(elementCategory);

        Project elementProject = new Project(++idCounterOfProject, "Project math for school", "Project for pupils 9-10 class", 100, 80, 31);
        projectOfCategory.add(elementProject);
        elementProject.addHistoryOfProject("We create new feature - online check your test", "Developer", Date.valueOf("2014-05-10"));
        elementProject.addDemoLink("Demo version", "http://");
        elementProject.addUserQuestionAnswer("How long are u going to develop this project?", "Ivanov", Date.valueOf("2014-01-15"));
        elementProject.addUserQuestionAnswer("During 3 month", "Moderator", Date.valueOf("2014-01-16"));

        elementProject = new Project(++idCounterOfProject, "Project english for school", "Do you speak english? Let's study together!!!", 1000, 756, 45);
        projectOfCategory.add(elementProject);
        elementProject.addHistoryOfProject("We finish case test! We start production as soon as possible", "Developer", Date.valueOf("2014-05-10"));
        elementProject.addDemoLink("Demo version", "http://");
        elementProject.addUserQuestionAnswer("Oh buddy it's good idea. I'm looking for similar project for pupils 2-3 class. Is it interesting for you?"
                , "Teacher", Date.valueOf("2014-03-22"));
        elementProject.addUserQuestionAnswer("Yes, send me your contact on offer@kickstarter.com", "Moderator", Date.valueOf("2014-01-16"));

        elementProject = new Project(++idCounterOfProject, "Project chemistry for school");
        projectOfCategory.add(elementProject);
//        List<Project>  copyList = new ArrayList<Project>();
//        copyList.addAll(projectOfCategory.subList(0, projectOfCategory.size()));
//        mappingCategoryAndProject.put(elementCategory, copyList);
        mappingCategoryAndProject.put(elementCategory, projectOfCategory);
        projectOfCategory = new ArrayList<Project>();

        elementCategory = new Category(++idCounterOfCategory, "Games");
        catalogCategory.add(elementCategory);

        elementProject = new Project(++idCounterOfProject, "Worms", "WORMS!!! WORMS!!! WORMS!!! Challenge everybody.", 5505, 5505, 1);
        elementProject.addHistoryOfProject("We decided to realized worms in 3D", "Developer", Date.valueOf("2014-05-10"));
        elementProject.addDemoLink("Demo version", "http://");
        elementProject.addUserQuestionAnswer("Will be there opportunity of multi and single player?", "Gamer Vasya", Date.valueOf("2014-07-25"));
        elementProject.addUserQuestionAnswer("Yeah, either we are going to start championship!!! And it will be soon.", "Moderator", Date.valueOf("2014-01-07"));
        projectOfCategory.add(elementProject);

        elementProject = new Project(++idCounterOfProject, "Balda");
        projectOfCategory.add(elementProject);
        elementProject = new Project(++idCounterOfProject, "Puzzles");
        projectOfCategory.add(elementProject);
//        copyList.addAll(projectOfCategory.subList(0, projectOfCategory.size()));
//        mappingCategoryAndProject.put(elementCategory, copyList);
        mappingCategoryAndProject.put(elementCategory, projectOfCategory);
        projectOfCategory = new ArrayList<Project>();

        elementCategory = new Category(++idCounterOfCategory, "Software");
        catalogCategory.add(elementCategory);
        mappingCategoryAndProject.put(elementCategory, projectOfCategory);

    }

    @Override
    public Map<Category, ArrayList<Project>> getMapping() {
        return mappingCategoryAndProject;
    }

    @Override
    public ArrayList<Category> getCategoryList() {
        return catalogCategory;
    }

    @Override
    public void saveData() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
