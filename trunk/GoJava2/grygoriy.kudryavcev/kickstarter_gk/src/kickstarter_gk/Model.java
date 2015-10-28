package kickstarter_gk;

import java.util.ArrayList;

public class Model {

	private int idCat; // TODO id категории
	private ArrayList<Category> allCategories;
	private ArrayList<Project> allProjects;
	private ArrayList<FAQ> allFAQs;
	ArrayList<PaymentVar> allPaymentVar;

	public Model() {
		allProjects = new ArrayList<Project>();
		allCategories = new ArrayList<Category>();
		allFAQs = new ArrayList<FAQ>();
		allPaymentVar = new ArrayList<PaymentVar>();
	}

	public void initCategory() {
		// метод первоначального заполнения таблицы с категориями.
		allCategories.add(new Category(0, "Sport", 0, "Sport Projects"));
		allCategories.add(new Category(1, "Cinema", 0, "Movies Projects"));
		allCategories.add(new Category(2, "HighTech", 0, "HighTech Projects"));
		allCategories.add(new Category(3, "Science", 0, "Science Projects"));
		allCategories.add(new Category(4, "Health", 0, "Health Projects"));
		idCat = 4;
	};

	public void initProjects() {
		allProjects.add(new Project("Project1 Reseach for bycycle",
				"Start smthg", 50000, 128, allCategories.get(0)));
		allProjects.add(new Project("Project2 name", "Research smthng", 10000,
				150, allCategories.get(0)));
		allProjects.add(new Project("Project3 name", "Research smthng", 20000,
				99, allCategories.get(1)));
		allProjects.add(new Project("Project4 name", "Research smthng", 40000,
				200, allCategories.get(1)));
		allProjects.add(new Project("Project5 name", "Research smthng", 50000,
				500, allCategories.get(3)));
		allProjects.add(new Project("Project6 name", "Research smthng", 60000,
				240, allCategories.get(3)));

	}

	public void initFAQs() {
		allFAQs.add(new FAQ("How do you come up this great idea?",
				"We drank allnight long", allProjects.get(0)));
		allFAQs.add(new FAQ("How do you come up this great idea?",
				"We smoke allnight long", allProjects.get(1)));
	}

	public void initPaymentVar() {
		allPaymentVar.add(new PaymentVar(allProjects.get(0), (float) 10,
				"We gift funny t-shorts for you!"));
		allPaymentVar.add(new PaymentVar(allProjects.get(0), (float) 100,
				"We gift ticker to show!"));
		allPaymentVar.add(new PaymentVar(allProjects.get(0), (float) 1000,
				"We dance for you!"));
		allPaymentVar.add(new PaymentVar(allProjects.get(0), (float) 10000,
				"We dance for you naked!"));

	}

	public ArrayList<Project> ProjectList() {
		return allProjects;
	}

	public ArrayList<Category> CategoryList() {
		return allCategories;
	}

	// Возвращаем список вопросов Проекта.

	public ArrayList<FAQ> getFaqInProject(Project project) {

		ArrayList<FAQ> FAQInProject = new ArrayList<FAQ>();

		int i = 0;
		for (i = 0; i < allFAQs.size(); i++) {
			if (allFAQs.get(i).getProject().equals(project)) {
				FAQInProject.add(allFAQs.get(i));
			}

		}

		return FAQInProject;
	}

	// Возвращаем список проектов в конкретной категории
	public ArrayList<Project> getProjectInCategory(Category category) {
		ArrayList<Project> projectInCategory = new ArrayList<Project>();
		int i = 0;

		Category cat = category;

		for (i = 0; i < allProjects.size(); i++) {
			Category tmpcat = allProjects.get(i).getCategory();
			if (cat.equals(tmpcat)) {
				projectInCategory.add(allProjects.get(i));
			}
		}
		return projectInCategory;
	}

	public void addNewFAQ(Project project, String Question) {

		allFAQs.add(new FAQ(Question, "No answer", project));

	}

	// Возвращаем список вопросов Проекта.

	public ArrayList<PaymentVar> getPaymentVarInProject(Project project) {

		ArrayList<PaymentVar> PaymentVarInProject = new ArrayList<PaymentVar>();

		int i = 0;
		for (i = 0; i < allPaymentVar.size(); i++) {
			if (allPaymentVar.get(i).getProject().equals(project)) {
				PaymentVarInProject.add(allPaymentVar.get(i));
			}

		}

		return PaymentVarInProject;
	}

}
