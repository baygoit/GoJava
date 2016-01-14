package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
public class ProjectPostgreDAO implements ProjectDAO {
	@Autowired
	private HibernateUtil hiberUtil;
	
	@Override
	public void clear() {
		hiberUtil.executeUpdate("delete Project");
	}

	@Override
	public Project get(int index) {
		return hiberUtil.get("from Project where id = ?", index);
	}

	@Override
	public void add(Project element) {
		hiberUtil.save(element);
	}

	@Override
	public void addAll(List<Project> elements) {
		hiberUtil.save(elements);
	}

	@Override
	public List<Project> getAll() {
		return hiberUtil.getList("from Project");
	}

	@Override
	public List<Project> getByCategory(int categoryId) {
		return hiberUtil.getList("from Project where category.id = ?", categoryId);
	}

}
