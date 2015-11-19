package ua.com.goit.gojava7.kickstarter.templates;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class AbstractTemplateFiles<T> implements Templateble<T> {
	private static final String PROBLEMS = "Ooops...something wrongs";
	protected File file;

	public AbstractTemplateFiles() {
		file = new File("d://gojava7/" + getClass().getName() + ".csv");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(PROBLEMS);
			}
		}
	}
	
	public abstract List<T> getAll();
}
