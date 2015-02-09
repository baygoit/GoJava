package kickstarter_gk;

import java.util.ArrayList;

public class Controler {

	
	int position;
	int level;
	
	    private Model model;
	    private View view;
	    private Scaner scan;
	    private Menu menu;
	     
	    
	    public  Controler(Model model, View view, Scaner scan, Menu menu) {
	        this.model = model;
	        this.view = view;
	        this.scan = scan;
	        this.menu = menu;
	    }

	    public void start() {
	    	// Инициализируем списки объектов
	        model.initCategory();
	        model.initProjects();
	        // Показываем цитату
	        view.showCitation();
	        
	        ArrayList<Project> projectsList = model.ProjectList();
	        ArrayList<Category> categoriesList = model.CategoryList();
		        
	        
	        
	        
//	        Меню
	        

	        boolean exitFromApplication = false;
	        while (!exitFromApplication) {
	     
	        	
	        	view.showLevelMenu(0, 0, model);
	        	// TODO логику!!!
	        	
	        
	    }
	      
//	        boolean exitFromApplication = false;
//	        while (!exitFromApplication) {
//	        	
//	            view.showCategories(categoriesList);
//	            int numberOfCategory = scan.Input();
//	            if (numberOfCategory == 0)
//	                break;
//	            boolean exitFromCategories = false;
//	            while (!exitFromCategories) {
//
//	            	// Показать все проекты в заданной категории;
//	            	ArrayList<Project> projectsInCategory = model.getProjectInCategory(categoriesList.get(numberOfCategory - 1)); 
//	            	view.showProjectsInCategory(projectsInCategory);
//           	
//	            	int numberOfProject = scan.Input();
//	                if (numberOfProject == 0)
//	                    break;
//	                boolean exitFromProject = false;
//	                while (!exitFromProject) {
//	                	
//	                	// Показываем конкретный проект.
//	                    
//	                	Project projectOne = projectsInCategory.get(numberOfProject - 1);
//	                	
//	                	view.showProject(projectOne);
//	                	
//	                	view.showProjectMenu();
//	                    int projectOption = scan.Input();
//	                    if (projectOption != 0) {
//	                        System.out.println("Selected option: ");
//	                    } else
//	                        System.out.println("Exiting from project");
//	                    exitFromProject = true;
//	                }
//	                if (numberOfProject == 0) {
//	                    break;
//
//	                }
//	            }
//	            if (numberOfCategory == 0) {
//	                break;
//
//	            }
//	        }
	        
	        
	        
	        
	        scan.finalize();
	    }

	    
	   
        			
       
	    
		
}
