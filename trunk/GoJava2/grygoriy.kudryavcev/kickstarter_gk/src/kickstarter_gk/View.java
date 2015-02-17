package kickstarter_gk;

import java.util.ArrayList;

public class View {

	private Citation StartCitation = new Citation();
	private Console viewPrint = new Console();

	private int level;
	private int position;
	private Model model;
	
//	ArrayList<Project> projectsInCategory;
//	Project projectOne;
//	ArrayList<Integer> menuHistory;
	
	
	// Показываем цитату
	
	public void showThis(String string){
		viewPrint.outhere(string);
	}

	public void showCitation() {
	     showThis(StartCitation.outCitation());   
		  }
	
	
	
	    public void showCategories(ArrayList<Category> list, int i) {
	        showThis("You entered: " + list.get(i - 1));
	    }

	    public void showCategories(ArrayList<Category> categoryList) {
	        int counter = 1;
	        for (Object category : categoryList) {
	        	showThis("(" + counter + ") " + category);
	        	counter++;
	        	
	        }
	        showSelect();

    }

	    public void showProject(Project project) {
	    	showThis(project.outLong());
	    }
	    

	    public void showProjectMenu() {
	        showThis("Select option: (not implemented, just '0' to exit)");
	    }
	    
	    public void showSelect(){
	    	showThis("Please, enter number to select, or 0 to exit");
	    }

		public void showProjectsInCategory(ArrayList<Project> projectsInCategory) {
			int i = 1;
				for (Project p : projectsInCategory){
            		showThis("("+i+")" + p.outLong());
					i++;
            	}
				showSelect();
		}
		// Вынести в контроллер. После выхода - выдавать управление на методы Оплаты и Вопросов. Потом возвращаться обратно.
		

			
// TODO Убрать. Это get Проекта.		
	
		
		}


