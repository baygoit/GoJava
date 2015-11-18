package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class FileProjectReader extends FileReader<Project> {

	public FileProjectReader(File file) {
		super(file);
	}

	@Override
	public List<Project> readIt() throws IOException {
		while ((fileReader.readLine()) != null) {
			Project project = new Project();
			project.setName(fileReader.readLine());
			project.setDescription(fileReader.readLine());
			project.setGoal(new Integer(fileReader.readLine()));
			project.setPledged(new Integer(fileReader.readLine()));
			project.setDaysToGo(new Integer(fileReader.readLine()));
			project.setHistory(fileReader.readLine());
			project.setLink(fileReader.readLine());
			project.setQuestionFile(fileReader.readLine());			
			FileRewardReader fileRewardReader = new FileRewardReader(new File(fileReader.readLine()));
			project.setRewards(fileRewardReader.read());
			
			data.add(project);
		}
		return data;
	}
}
