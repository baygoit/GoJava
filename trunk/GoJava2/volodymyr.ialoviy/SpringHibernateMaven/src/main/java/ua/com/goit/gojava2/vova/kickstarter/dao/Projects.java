package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;

@Repository("projectDao")
public class Projects extends AbstractDao implements ProjectDao {

	@Override
	public void saveProject(Project project) {
		getSession().save(project);
	}

	@Override
	public List<Project> findAllProjects(int id) {
		return (List<Project>) getSession().createCriteria(Project.class)
				.add(Restrictions.eq("idCategory", id)).list();
	}

	@Override
	public void deleteProjectById(int id) {
		Project project = (Project) getSession().load(Project.class, id);
		getSession().delete(project);
	}

	@Override
	public Project getProgect(int id) {
		return (Project) getSession().get(Project.class, id);
	}

	@Override
	public void addDonate(int amount, int id) {//TODO SWITH HQL TO NOT HQL
		Query query = getSession().createQuery("update Project set howMuchCollected = howMuchCollected + :amount, "
						+ "howMuchRemaining = howMuchRemaining - :amount"
						+ " where id = :id");
		query.setInteger("id", id);
		query.setInteger("amount", amount);
		query.executeUpdate();
	}
}
