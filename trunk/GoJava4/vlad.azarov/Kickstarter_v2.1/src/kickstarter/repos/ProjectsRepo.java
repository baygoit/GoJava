package kickstarter.repos;

import java.util.ArrayList;

import kickstarter.model.Category;
import kickstarter.model.Project;

public class ProjectsRepo implements Repo {
    
    private ArrayList<Project> projects;
    private CategoriesRepo categoriesRepo;

    public ProjectsRepo() {
	projects = new ArrayList<>();
	categoriesRepo = new CategoriesRepo();
	add(new Project(
		"SNAP",
		"Design Your Own Furniture",
		15000,
		27000,
		30,
		"With SNAP you can create endless solutions for your living space. You can "
			+ "transform any surface into a unique piece of furniture.",
		"http://www.youtube.com/01", categoriesRepo.getCategory("TECHNOLOGY")));
	add(new Project("HYDAWAY",
		"A Pocket-Sized Water Bottle Fit for any Adventure", 20000,
		181437, 3,
		"HYDAWAY is a handy alternative to disposable plastic water bottles - it folds"
			+ "down easily to fit in almost any pocket!",
		"http://www.youtube.com/0143534", categoriesRepo.getCategory("TECHNOLOGY")));
	add(new Project(
		"DASH 4.0 WALLET",
		"A Minimal Wallet Redefined",
		5000,
		46848,
		52,
		"The ORIGINAL quickdraw wallet for minimalists. Carry the things you need, and "
			+ "access them easily.",
		"http://www.youtube.com/0143534", categoriesRepo.getCategory("TECHNOLOGY")));
	add(new Project("USB CHARGEDOUBLER", "Double your charging speed!",
		2750, 2140, 32,
		"THE ORIGINAL Up to 200% charging speed for iPhone & Android. No data theft. "
			+ "The magnetic usb cable for your keyring.",
		"http://www.youtube.com/0143534", categoriesRepo.getCategory("TECHNOLOGY")));

	add(new Project(
		"FIREFLY HAND",
		"Light up your life",
		3500,
		470,
		25,
		"FireFly Hand is the next generation electric "
			+ "flashlight, which is capable of making your life significantly easier.",
		"http://www.youtube.com/0143534", categoriesRepo.getCategory("DESIGN")));
	add(new Project(
		"CUBIT",
		"The Make Anything Platform",
		50000,
		169,
		34,
		"A platform that brings together plug & play hardware and drag & drop software "
			+ "to allow everyone to create and invent!",
		"http://www.youtube.com/0143534", categoriesRepo.getCategory("DESIGN")));
	add(new Project(
		"NOKI",
		"The smart doorlock for Europe",
		125000,
		119082,
		44,
		"Noki is the first smart doorlock for Europe. It opens your door when you come "
			+ "home and locks it when you leave.",
		"http://www.youtube.com/031234", categoriesRepo.getCategory("DESIGN")));
    }

    public void add(Project project) {
	projects.add(project);
    }

    public Project getProject(String string) {
	for (Project project : projects) {
	    if (project.getName().equals(string)) {
		return project;
	    }
	}
	System.out.println("There is no such project");
	return null;
    }
    
    public ArrayList<Project> getProjects(String projectName) {
	ArrayList<Project> tempProjectsArray = new ArrayList<>();
	for (Project project : projects) {
	    if (project.getName().equals(projectName)) {
		tempProjectsArray.add(project);
	    }
	}
	return tempProjectsArray;
    }


    public ArrayList<Project> getProjects(Category category) {
	ArrayList<Project> tempCategoryProjectsArray = new ArrayList<>();
	for (Project project : projects) {
	    if (project.getCategory().getName().equals(category.getName())) {
		tempCategoryProjectsArray.add(project);
	    }
	}
	return tempCategoryProjectsArray;
    }
    
    // public ArrayList<Project> getProjectsOfCategoryArray(Category category) {
    // ArrayList<Project> result = new ArrayList<>();
    // for (Project project : projects){
    // if (project.getCategory().equals(category)){
    // result.add(project);
    // }
    // }
    // return result;
    // }

    // public boolean isCurrentProjectExist(int projectId, Category category) {
    // for (Project project : projects){
    // if ((project.getId() == projectId) &&
    // (project.getCategory().equals(category))){
    // return true;
    // };
    // }
    // return false;
    // }

    // public Project getProjectByIdAndCategory(int projectId, Category
    // category) {
    // for (Project project : projects){
    // if ((project.getId() == projectId) &&
    // (project.getCategory().equals(category))){
    // return project;
    // };
    // }
    // return null;
    // }
}
