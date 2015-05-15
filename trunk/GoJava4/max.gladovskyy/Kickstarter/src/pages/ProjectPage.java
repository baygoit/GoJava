package pages;

import java.util.ArrayList;

import kickstarter.Kickstarter;
import datasource.DataSource;
import entities.Project;

public class ProjectPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private ArrayList<String> page = new ArrayList<String>();
	private Project project;

	
	
	public ProjectPage(int category, int project) {
		this.project = dataSource.getProject(category, project);
	}

	@Override
	public ArrayList<String> getPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
