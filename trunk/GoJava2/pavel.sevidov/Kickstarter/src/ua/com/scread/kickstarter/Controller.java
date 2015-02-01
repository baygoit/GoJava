package ua.com.scread.kickstarter;

import java.util.ArrayList;

public class Controller {
	private Model model;
    private View view;
    private Scan scan;

    public Controller(Model model, View view, Scan scan) {
        this.model = model;
        this.view = view;
        this.scan = scan;
    }
    
//    UserStory V
//    Как гость я хочу иметь возможность изучать разные проекты в различных категориях
//    Сценарий1: Находясь в списке проектов -> вижу запрос на выбор проекта и пункт 
//    меню "0 - выход" -> выбираю 0 -> попадаю в меню категорий -> Вижу список категорий и 
//    возможность выбора другой категории
//    Сценарий2: Находясь в описании проекта -> вижу меню "0 - выход" -> выбираю 0 -> попадаю 
//    в меню проектов -> Вижу список проектов и возможность выбора другого проекта
    
    public void start() {
        model.init();
        view.greed();
        
//        model.init();
//        view.showGreeting();
//        List<Project> projectsList = model.getProjectsList();
//        List<Category> categoriesList = model.getCategoriesList();
//
//        boolean exitFromApplication = false;
//        while (!exitFromApplication) {
//            view.showCategories(categoriesList);
//            int numberOfCategory = scan.getAnswer();
//            if ((numberOfCategory == 0) || (numberOfCategory > categoriesList.size()))
//                break;
//            boolean exitFromCategories = false;
//            while (!exitFromCategories) {
//                view.showProjects(categoriesList.get(numberOfCategory - 1).getProjectsList());
//                int numberOfProject = scan.getAnswer();
//                if ((numberOfProject == 0) || (numberOfProject > categoriesList.get(numberOfCategory - 1).getProjectsList().size()))
//                    break;
//                boolean exitFromProject = false;
//                while (!exitFromProject) {
//                    view.showProject(categoriesList.get(numberOfCategory - 1).getProjectsList()
//                            .get(numberOfProject - 1));
//                    view.showProjectMenu();
//                    int projectOption = scan.getAnswer();
//                    if (projectOption != 0) {
//                        System.out.println("Selected option: ");
//                    } else
//                        System.out.println("Exiting from project");
//                    exitFromProject = true;
//                }
//                if (numberOfProject == 0) {
//                    break;
//                }
//            }
//            if (numberOfCategory == 0) {
//                break;
//            }
//        }
//        scan.close();

        
        Categories categories = model.getCategories();
        
        boolean exitApp = false;
        while(!exitApp) {
        	view.showCategoies(categories);	
        	int numberOfCategory = scan.getAnswer();
        	if ((numberOfCategory == 0) || (numberOfCategory > categories.getCategories().size()))
        		break;
        	Category category = categories.getCategory(numberOfCategory-1);
        	boolean exitCategories = false;
        	while (!exitCategories) {
        		view.showCategory(category);
        		ArrayList<Project> projects = model.getProjects(category);
        		view.showProjects(projects);
        		int answer = scan.getAnswer();
        		if ((answer == 0) || (answer > projects.size()))
        			break;
        		Project project = projects.get(answer-1);
        		boolean exitProjects = false;
        		while (!exitProjects) {
        			view.showFullProject(project); 
        			int projectOption = scan.getAnswer();
        			if (projectOption != 0) {
        				System.out.println("Selected option: ");
        			} else
        				System.out.println("Exiting from project");
        			exitProjects = true;
        		}// всунуть считывание в циклы соответсвующее
        		if (answer == 0) 
        			break;
        	if (numberOfCategory == 0)
        		break;
        	}  
        }
    }

}
