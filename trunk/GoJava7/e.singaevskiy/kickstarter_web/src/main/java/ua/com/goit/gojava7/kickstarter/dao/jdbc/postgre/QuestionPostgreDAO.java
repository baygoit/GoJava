package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Repository
public class QuestionPostgreDAO implements QuestionsDAO{
	@Autowired
	private HibernateUtil hiberUtil;	
	
    @Override
    public void clear() {
    	hiberUtil.executeUpdate("delete Question");
    }

    @Override
    public Question get(int index) {
        return hiberUtil.get("from Question where id = ?", index);
    }

    @Override
    public void add(Question element) {
    	hiberUtil.save(element);
    }

    @Override
    public void addAll(List<Question> elements) {
    	hiberUtil.save(elements);
    }

    @Override
    public List<Question> getAll() {
    	return hiberUtil.getList("from Question");
    }

    @Override
    public List<Question> getByProject(int projectId) {
        return hiberUtil.getList("from Question where project.id = ?", projectId);
    }

}
