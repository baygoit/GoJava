package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
		Query query = getSession().createQuery("from Project where idCategory = :id");
		query.setInteger("id", id);
		List<Project> rezult = (List<Project>) query.list();
		return rezult;
	}

	@Override
	public void deleteProjectById(int id) {
		Query query = getSession().createSQLQuery("delete from Projects where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public Project getProgect(int id) {
		Query query = getSession().createQuery("from Project where id = :id");
		query.setInteger("id", id);
		List<Project> projects = (List<Project>) query.list();
		Project rezult = projects.get(0);
		return rezult;
	}

	@Override
	public void addDonate(int amount, int id) {
		Query query = getSession().createQuery("update Project set howMuchCollected = howMuchCollected + :amount, "
						+ "howMuchRemaining = howMuchRemaining - :amount"
						+ " where id = :id");
		query.setInteger("id", id);
		query.setInteger("amount", amount);
		query.executeUpdate();
	}
}
