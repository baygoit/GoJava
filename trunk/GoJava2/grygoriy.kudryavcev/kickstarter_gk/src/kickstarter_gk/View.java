package kickstarter_gk;

import java.util.ArrayList;

public class View {

	private Citation StartCitation = new Citation();
	private Console viewPrint = new Console();

	// Показываем цитату
	
	 public void showCitation() {
	     viewPrint.outhere(StartCitation.outCitation());   
		  }
	
	    public void showCategories(ArrayList<Category> list, int i) {
	        viewPrint.outhere("You entered: " + list.get(i - 1));
	    }

	    public void showCategories(ArrayList<Category> categoryList) {
	        int counter = 1;
	        for (Object category : categoryList) {
	        	viewPrint.outhere("(" + counter + ") " + category);
	        	counter++;
	        	
	        }
	        showSelect();

    }

	    public void showProject(Project project) {
	    	viewPrint.outhere(project.outLong());
	    }
	    

	    public void showProjectMenu() {
	        viewPrint.outhere("Select option: (not implemented, just '0' to exit)");
	    }
	    
	    public void showSelect(){
	    	viewPrint.outhere("Please, enter number to select, or 0 to exit");
	    }

		public void showProjectsInCategory(ArrayList<Project> projectsInCategory) {
			int projectSize = projectsInCategory.size();
			int i = 1;
				for (Project p : projectsInCategory){
            		viewPrint.outhere("("+i+")" + p.outLong());
//					showProject(p);
					i++;
            	}
				showSelect();
		}

}
