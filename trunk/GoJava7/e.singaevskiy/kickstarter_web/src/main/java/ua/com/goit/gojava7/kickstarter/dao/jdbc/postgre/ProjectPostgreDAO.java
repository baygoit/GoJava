package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectPostgreDAO implements ProjectDAO {
	
	@Override
	public void clear() {
		HibernateUtil.executeUpdate("delete Project");
	}

	@Override
	public Project get(int index) {
		return HibernateUtil.get("from Project where id = ?", index);
	}

	@Override
	public void add(Project element) {
		HibernateUtil.save(element);
	}

	@Override
	public void addAll(List<Project> elements) {
		HibernateUtil.save(elements);
	}

	@Override
	public List<Project> getAll() {
		return HibernateUtil.getList("from Project");
	}

	@Override
	public List<Project> getByCategory(int categoryId) {
		return HibernateUtil.getList("from Project where category.id = ?", categoryId);
	}

}
