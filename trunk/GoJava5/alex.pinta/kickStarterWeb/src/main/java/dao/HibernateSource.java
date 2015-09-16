package dao;

import model.Category;
import model.Project;
import model.Quote;
import org.hibernate.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import utils.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 26.08.15
 * Time: 13:55
 */
public class HibernateSource implements LoadingData{
    private SessionFactory sessionFactory;
    public static final int FETCH_SIZE = 1;

    public HibernateSource(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        try {
            List categories = getCategoryList();
            if (categories.isEmpty()){
                StringBuilder stringBuilder = RWFileService.getTextFromFile(getClass().getResource("/Hibernate/DefaultInsertData.txt").getFile(),'\n');
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();
                SQLQuery sqlQuery = session.createSQLQuery(stringBuilder.toString());
                sqlQuery.executeUpdate();
            }
        } catch (Exception e){
            //Do nothing
            //tables weren't created
        }
    }

    @Override
    public List<Category> getCategoryList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Category> categories = new ArrayList<>();
        for (Object elem : session.createQuery("from model.Category").list()){
            categories.add((Category) elem);
        }

        transaction.commit();
        session.close();
        return categories;
    }

    @Override
    public Category getCategoryByID(int categoryId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from model.Category where Id = :Id");
        query.setInteger("Id", categoryId);

        query.setReadOnly(true);
        query.setFetchSize(FETCH_SIZE);
        ScrollableResults results = query.scroll(ScrollMode.FORWARD_ONLY);

        if (results.next()){
            session.close();
            return (Category) results.get(FETCH_SIZE-1);
        }
        transaction.commit();
        session.close();
        return null;

    }

    @Override
    public List<Project> getListOfProjectByCategoryID(int categoryId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project> projects = new ArrayList<>();

        Query query = session.createQuery("from model.Project where category_id = :categoryID");
        query.setInteger("categoryID", categoryId);
        for (Object elem : query.list()){
            projects.add((Project) elem);
        }

        transaction.commit();
        session.close();
        return projects;
    }

    @Override
    public List<Quote> getQuoteList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Project getProjectByID(int projectId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project> projects = new ArrayList<>();

        Query query = session.createQuery("from model.Project where id = :projectId");
        query.setInteger("projectId", projectId);

        query.setReadOnly(true);
        query.setFetchSize(FETCH_SIZE);
        ScrollableResults results = query.scroll(ScrollMode.FORWARD_ONLY);

        if (results.next()){
            session.close();
            return (Project) results.get(FETCH_SIZE-1);
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void updateUserQuestionAnswerOfProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project.QuestionAnswer> questionAnswers = new ArrayList<>();

        Query query = session.createQuery("from model.Project$QuestionAnswer where project_id = :projectID");
        query.setInteger("projectID", project.getId());
        for (Object elem : query.list()){
            questionAnswers.add((Project.QuestionAnswer) elem);
        }
        project.setUserQuestion(questionAnswers);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateDemoLinkOfProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project.VideoLink> videoLinks = new ArrayList<>();

        Query query = session.createQuery("from model.Project$VideoLink where project_id = :projectID");
        query.setInteger("projectID", project.getId());
        for (Object elem : query.list()){
            videoLinks.add((Project.VideoLink) elem);
        }
        project.setDemoLink(videoLinks);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateHistoryOfProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project.History> histories = new ArrayList<>();

        Query query = session.createQuery("from model.Project$History where project_id = :projectID");
        query.setInteger("projectID", project.getId());
        for (Object elem : query.list()){
            histories.add((Project.History) elem);
        }
        project.setHistoryOfProject(histories);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateTermsOfProject(Project project){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project.Terms> termsList = new ArrayList<>();

        Query query = session.createQuery("from model.Project$Terms where project_id = :projectID");
        query.setInteger("projectID", project.getId());
        for (Object elem : query.list()){
            termsList.add((Project.Terms) elem);
        }
        project.setTermsList(termsList);
        transaction.commit();
        session.close();
    }

    @Override
    public <T> void setInfoOfProject(Project project, String field, T value){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Method method;
        try {
            Class[] cArg = new Class[1];
            cArg[0] = value.getClass();
            method = Project.class.getDeclaredMethod("set"+String.valueOf(field.charAt(0)).toUpperCase()+field.substring(1), cArg);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Illegal name of class field");
        }
        try {
            method.invoke(project, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unexpected type of value for class field: " + field);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unexpected type of value for class field: " + field);
        }

        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
    }

    @Override
    public void setQuestionAnswerOfProject(Project project, String description, String user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        project.addUserQuestionAnswer(description, user, new Date(System.currentTimeMillis()));
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
    }


    @Override
    public Project.Terms getTermByID(int projectId, int termId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project> projects = new ArrayList<>();

        Query query = session.createQuery("from model.Project$Terms where project_id = :projectID and id = :termId");
        query.setInteger("projectID", projectId);
        query.setInteger("termId", termId);

        query.setReadOnly(true);
        query.setFetchSize(FETCH_SIZE);
        ScrollableResults results = query.scroll(ScrollMode.FORWARD_ONLY);

        if (results.next()){
            session.close();
            return (Project.Terms) results.get(FETCH_SIZE-1);
        }
        transaction.commit();
        session.close();
        return null;
    }

}
