package ua.com.goit.gojava.kickstarter.DAO;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Model.Faq;
import ua.com.goit.gojava.kickstarter.Model.Project;

@Component
public class FaqDAO extends AbstractDAO {
	
	public List<Faq> getFaq(Project project) {
		Query query = getSession().createQuery("FROM faq f WHERE f.project_id = :projectId");
		query.setParameter("projectId", project.getId());
		List<Faq> list = (List<Faq>) query.list();
		return list;
	}

}
