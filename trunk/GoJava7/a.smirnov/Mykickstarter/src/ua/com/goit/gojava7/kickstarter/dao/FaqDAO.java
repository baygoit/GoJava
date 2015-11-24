package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public interface FaqDAO {
	
	public void add(Faq faq);

	public void remove(Faq faq);
	
	public List<Faq> getAll();
	
	public int getSize();

	public String getProjectFaqs(Project project);

}
