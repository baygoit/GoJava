package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractFaqDao {
	
	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(Faq element);

	public abstract void remove(Faq element);
	
	public abstract List<Faq> getAll();
	
	public abstract int getSize();
	
	public abstract String getProjectFaqs(Project project);
	
	
	
}
