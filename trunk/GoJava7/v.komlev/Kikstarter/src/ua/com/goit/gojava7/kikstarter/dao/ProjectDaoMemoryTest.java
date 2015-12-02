package ua.com.goit.gojava7.kikstarter.dao;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.dao.database.ProjectDaoDb;
import ua.com.goit.gojava7.kikstarter.dao.file.CategoryDaoFile;
import ua.com.goit.gojava7.kikstarter.dao.file.ProjectDaoFile;
import ua.com.goit.gojava7.kikstarter.dao.memory.MemoryProjectReader;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class ProjectDaoMemoryTest extends ProjectDaoFile {

	private List<Project> projects = new ArrayList<>();

	public ProjectDaoMemoryTest() {
		setProject();
	}

	public List<Project> setProject() {
		return projects = new MemoryProjectReader().readProjects();
	}

	public Project getProject(int index) {
		return projects.get(index - 1);
	}

	public static void main(String[] args) {

		ProjectDaoMemoryTest projectDaoMemoryTest = new ProjectDaoMemoryTest();
		ProjectDaoDb projectDaoDb=new ProjectDaoDb();
//		projectDaoDb.add(projectDaoMemoryTest.getProject(2));
//		projectDaoDb.add(projectDaoMemoryTest.getProject(3));
//		projectDaoFile.add(projectDaoMemoryTest.getProject(1));
//		projectDaoFile.add(projectDaoMemoryTest.getProject(2));
//		projectDaoFile.add(projectDaoMemoryTest.getProject(3));

		List<Project> projects = projectDaoDb.getAll();

	}
}
