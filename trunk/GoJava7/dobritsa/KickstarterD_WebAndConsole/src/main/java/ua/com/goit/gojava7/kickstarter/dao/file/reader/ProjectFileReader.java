package ua.com.goit.gojava7.kickstarter.dao.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectFileReader extends FileReader<Project> {

	public ProjectFileReader(File file) {
		super(file);
	}

	@Override
	public List<Project> readFromFile(BufferedReader bufferedReader) throws IOException {
		while ((bufferedReader.readLine()) != null) {
			String name = bufferedReader.readLine();
			String description = bufferedReader.readLine();
			int goal = new Integer(bufferedReader.readLine());
			int pledged = new Integer(bufferedReader.readLine());
			int daysToGo = new Integer(bufferedReader.readLine());

			Project project = new Project();
			project.setName(name);
			project.setDescription(description);
			project.setGoal(goal);
			project.setPledged(pledged);
			project.setDaysToGo(daysToGo);
			project.setHistory(bufferedReader.readLine());
			project.setLink(bufferedReader.readLine());

			String categoryName = bufferedReader.readLine();
			project.setCategoryName(categoryName);
			data.add(project);
		}
		return data;
	}

}
