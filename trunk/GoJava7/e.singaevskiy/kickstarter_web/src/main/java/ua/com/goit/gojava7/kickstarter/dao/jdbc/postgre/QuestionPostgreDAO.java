package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionPostgreDAO implements QuestionsDAO{

    @Override
    public void clear() {
    	HibernateUtil.executeUpdate("delete Question");
    }

    @Override
    public Question get(int index) {
        return HibernateUtil.get("from Question where id = ?", index);
    }

    @Override
    public void add(Question element) {
    	HibernateUtil.save(element);
    }

    @Override
    public void addAll(List<Question> elements) {
    	HibernateUtil.save(elements);
    }

    @Override
    public List<Question> getAll() {
    	return HibernateUtil.getList("from Question");
    }

    @Override
    public List<Question> getByProject(int projectId) {
        return HibernateUtil.getList("from Question where project.id = ?", projectId);
    }

}
