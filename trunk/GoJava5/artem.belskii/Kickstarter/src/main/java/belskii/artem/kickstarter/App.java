package belskii.artem.kickstarter;

import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        Motivation motivation = initializeMotivationFromDatabase();
        Random randomID;
        System.out.println(motivation.getMotivation());
        
		Category categoryModel = retriveCategoryFromDatabase ();
		CategoryView categoryView = new CategoryView();
		CategoryController categoryController = new CategoryController(categoryModel, categoryView);
		categoryController.addCategory("Music");
		categoryController.updateView();

		Projects projectsModel = retriveProjectFromDatabase();
		ProjectsView projectsView = new ProjectsView();
		ProjectsController projectsController = new ProjectsController(projectsModel, projectsView);
		projectsController.printProjectsList();
		
		
    }

	
    private static Motivation initializeMotivationFromDatabase(){
		Motivation motivation = new Motivation();
		motivation.addMotivation("Рекорды существуют для того, чтобы их бить.");
		motivation.addMotivation("Знаний не достаточно, ты должен применять их. Желания не достаточно, ты должен делать.");
		motivation.addMotivation("Если вы хотите заставить человека смеяться вашим шуткам, скажите ему, что у него есть чувство юмора");
		motivation.addMotivation("Ночь не может длиться вечно.");
		motivation.addMotivation("Пессимист видит трудность в любой возможности; оптимист – видит возможность в любой трудности.");
		return motivation;
    	
    }
    private static Category retriveCategoryFromDatabase() {
		Category category = new Category();
		category.addCategory("Techno");
		category.addCategory("Art");
		category.addCategory("Sport");
		category.addCategory("Some category");
		return category;
	}
    
    private static Projects retriveProjectFromDatabase(){
		Projects projects = new Projects();
		projects.addProject("Мой самый лучшей проект", "Выберете нас, и мы сделаем все отлично!");
		projects.addProject("Мой ееще более лучшей проект", "Лучше выберене нас!");
    	return projects;
    	
    }
	
	
}
