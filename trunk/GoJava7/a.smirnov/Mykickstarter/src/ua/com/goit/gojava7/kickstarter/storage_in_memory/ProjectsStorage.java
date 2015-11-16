package ua.com.goit.gojava7.kickstarter.storage_in_memory;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.templates.AbstractTemplateMemory;

public class ProjectsStorage extends AbstractTemplateMemory<Project> {
	
	public ProjectsStorage(CategoriesStorage categoriesStorage) {
	
		Project project1 = new Project("Broadway Arts Lab Company presents Elf JR: The Musical", 
				"A nonprofit arts education program for young people to explore their unique and "
				+ "individual talents through Musical Theatre.", 30_000);
		project1.setExpiryDays(07, 12, 2015);
		project1.addFullDescription("In 2012 the BROADWAY ARTS LAB COMPANY (BALC) opened its doors to "
				+ "young artists providing a safe environment to explore their unique and individual "
				+ "talents through the medium of live theatre, specifically acting, singing, dancing "
				+ "and music.");
		project1.addLinkOnVideo("https://www.youtube.com");
		project1.setCategory(categoriesStorage.convertSetInList(categoriesStorage.getAll()).get(0));

		Project project2 = new Project("Bassel's Street Food", "Super amazing street food from quality ingredients.",
				45_000);
		project2.setExpiryDays(15, 12, 2015);
		project2.addFullDescription("Clear Food is the authoritative online food guide for consumers. "
				+ "We are evaluating food at the molecular level to surface insights about our food that "
				+ "go far beyond the label. We can discover hidden additives, trace allergens, and unintended "
				+ "ingredients. Is your veggie burger really meat-free? Are your kids’ chicken nuggets 100% "
				+ "chicken like the label says? Is there wheat in your gluten-free pizza crust? Our "
				+ "advanced genomic analysis uncovers it all.");
		project2.addLinkOnVideo("https://www.youtube.com");
		project2.setCategory(categoriesStorage.convertSetInList(categoriesStorage.getAll()).get(0));

		Project project3 = new Project("First Ever Soft Shell Football Helmet",
				"Designed by former NFL players, Rocksolid brings to you the RS1, "
						+ "the world's first soft shell helmet created specifically for football",
				120_000);
		project3.addFullDescription("As former NFL players, we are committed to adding protection to football and"
				+ " making it more enjoyable for everyone. There's a major void in player safety in non-contact play, "
				+ "such as flag football, 7v7, padless play, and off-season practice. Did you know that 80% of practice "
				+ "time is without traditional football pads, and that most injuries actually occur in the off-season?");
		project3.addLinkOnVideo("https://www.youtube.com");
		project3.setCategory(categoriesStorage.convertSetInList(categoriesStorage.getAll()).get(1));
		
		add(project1);
		add(project2);
		add(project3);
	}
	
	public Set<Project> getAllProjectsFromCategory(Category category) {
		Set<Project> allExistingProjects = getAll();
		Set<Project> allProjectsFromSelectedCategory = new TreeSet<>();
		
		Iterator<Project> iteratorProjects = allExistingProjects.iterator();
		
		while (iteratorProjects.hasNext()) {
			Project project = iteratorProjects.next();
			if (project.getCategory().getName().equals(category.getName())) {
				allProjectsFromSelectedCategory.add(project);
			}
		}

		return allProjectsFromSelectedCategory;
	}
}
