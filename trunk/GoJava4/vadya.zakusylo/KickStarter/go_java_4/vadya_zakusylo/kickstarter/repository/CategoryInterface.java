package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.List;

public interface CategoryInterface {

	public String getName();

	public void addProject(ProjectInterface project);

	public void removeProject(ProjectInterface project);

	public List<ProjectInterface> getProjects();

}
