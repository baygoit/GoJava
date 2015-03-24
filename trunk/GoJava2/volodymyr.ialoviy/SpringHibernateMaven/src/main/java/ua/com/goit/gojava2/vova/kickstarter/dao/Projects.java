package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Project;

@Repository("projectDao")
public class Projects extends AbstractDao implements ProjectDao {

	@Override
	public void saveProject(Project project) {
		persist(project);
	}

	@Override
	public List<Project> findAllProjects(Integer idCategory) {
		Query query = getSession().createQuery(
				"from Project where idCategory = :idCategory");
		query.setInteger("idCategory", idCategory);
		List<Project> rezult = (List<Project>) query.list();
		return rezult;
	}

	@Override
	public void deleteProjectById(Integer idProject) {
		Query query = getSession().createSQLQuery(
				"delete from Projects where id_project = :idProject");
		query.setInteger("idProject", idProject);
		query.executeUpdate();
	}

	@Override
	public Project getProgect(Integer idProject) {
		Query query = getSession().createQuery(
				"from Project where idProject = :idProject");
		query.setInteger("idProject", idProject);
		List<Project> projects = (List<Project>) query.list();
		Project rezult = projects.get(0);
		return rezult;
	}

	@Override
	public void addDonate(Integer amount, Integer idProject) {
		Query query = getSession().createQuery("update Project set howMuchCollected = howMuchCollected + :amount, "
						+ "howMuchRemaining = howMuchRemaining - :amount"
						+ " where idProject = :idProject");
		query.setInteger("idProject", idProject);
		query.setInteger("amount", amount);
		query.executeUpdate();
	}
}
