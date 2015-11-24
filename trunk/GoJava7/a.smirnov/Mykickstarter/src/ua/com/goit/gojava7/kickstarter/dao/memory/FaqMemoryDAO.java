package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractFaqStorage;

public class FaqMemoryDAO extends AbstractFaqStorage {

	private List<Faq> faqs = new ArrayList<>();
	
	@Override
	public void add(Faq faq) {
		faqs.add(faq);
	}

	@Override
	public void remove(Faq faq) {
		faqs.remove(faq);
	}

	@Override
	public List<Faq> getAll() {
		return faqs;
	}

	@Override
	public int getSize() {
		return faqs.size();
	}
	
	@Override
	public String getProjectFaqs(Project project) {
		List<Faq> allFaqs = getAll();
		StringBuilder resultFaqs = new StringBuilder();
		
		for (int index = 0; index < allFaqs.size(); index ++) {
			if (allFaqs.get(index).getProjectID() == project.getUniqueID()) {
				resultFaqs.append("\n  question : " + allFaqs.get(index).getQuestion() + "\n");
				
				if (allFaqs.get(index).getAnswer() == null || allFaqs.get(index).getAnswer().isEmpty()) {
					resultFaqs.append("  answer: There is no answer yet \n");
				} else {
					resultFaqs.append("  answer : " + allFaqs.get(index).getAnswer() + "\n");
				}	
			}
		}
		
		if (resultFaqs.length() == 0) {
			return "no questions";
		} else {
			return resultFaqs.toString();
		}
	}	
}
