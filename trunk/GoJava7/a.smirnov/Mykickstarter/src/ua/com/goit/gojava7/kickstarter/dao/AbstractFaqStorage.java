package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractFaqStorage implements Storage<Faq>{
	
	public abstract String getProjectFaqs(Project project);
	
}
