package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class FileCategoryReader extends FileReader<Category> implements CategoryReader {
	//private List<File> categoriesFile;

	public FileCategoryReader(File file) {
		super(file);
	}

	@Override
	public List<Category> readIt() throws IOException {

		String line;
		while ((line = fileReader.readLine()) != null) {
			Category category = new Category(line);
			category.addPathFile(fileReader.readLine());			
			
			//BufferedReader fileReaderProject = null;
			//InputStream projectsFileSteam = new FileInputStream(file1);
			//fileReaderProject = new BufferedReader(new InputStreamReader(projectsFileSteam));
			//while ((fileReaderProject.readLine()) != null) {
			//	Project project = new Project();
			//	project.setName(fileReaderProject.readLine());
			//	project.setDescription(fileReaderProject.readLine());
			//	project.setGoal(new Integer(fileReaderProject.readLine()));
			//	project.setPledged(new Integer(fileReaderProject.readLine()));
			//	project.setDaysToGo(new Integer(fileReaderProject.readLine()));
			//	project.setHistory(fileReaderProject.readLine());
			//	project.setLink(fileReaderProject.readLine());
			///	project.setQuestionFile(fileReaderProject.readLine());
			//	project.setRewardFile(fileReaderProject.readLine());
			//	category.add(project);
			//}
			data.add(category);
		}
		return data;

	}
}
