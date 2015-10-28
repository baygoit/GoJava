package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Question;

@Repository("questionDao")
public class Questions extends AbstractDao implements QuestionDao {

	@Override
	public void saveQuestion(Question question) {
		getSession().save(question);
	}

	@Override
	public List<Question> findAllQuestions(int id) {
		return (List<Question>) getSession().createCriteria(Question.class)
				.add(Restrictions.eq("idProject", id)).list();
	}

	@Override
	public void deleteQuestionById(int id) {
		Question question = (Question) getSession().load(Question.class, id);
		getSession().delete(question);
	}

	@Override
	public Question getQuestion(int id) {
		return (Question) getSession().get(Question.class, id);
	}

	@Override
	public void addAnswer(String answer, int id) {
		Query query = getSession().createQuery(
				"update Question set answer = :answer"
						+ " where id = :id");
		query.setInteger("id", id);
		query.setString("answer", answer);
		query.executeUpdate();
	}
}
