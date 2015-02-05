package kickstarter_gk;

import java.util.ArrayList;

public class View {

	private Citation StartCitation = new Citation();
	private Console viewPrint = new Console();

	// Показываем цитату
	
	 public void showCitation() {
	     viewPrint.outhere(StartCitation.outCitation());   
		  }
	

	 
	 
//	 public void showProjects(List<Project> projectslist) {
//	        int counter = 1;
//	        for (Object project : projectslist) {
//	            out.output("(" + counter + ") " + project);
//	            counter++;
//	        }
//	    }
//
	    public void showCategories(ArrayList<Category> list, int i) {
	        viewPrint.outhere("You entered: " + list.get(i - 1));
	    }

	    public void showCategories(ArrayList<Category> categoryList) {
	        int counter = 1;
	        for (Object category : categoryList) {
	        	viewPrint.outhere("(" + counter + ") " + category);
	        	counter++;
	        }

    }

	    public void showProject(Project project) {
	    	viewPrint.outhere(project.outLong());
	    
	    }
	    
//
	    public void showProjectMenu() {
	        viewPrint.outhere("Select option: (not implemented, just '0' to exit)");
	    }
//
//	    public void showList(List<Object> list) {
//	        int counter = 1;
//	        for (Object element : list) {
//	            out.output("(" + counter + ") " + element);
//	            counter++;
//	        }
//	    }
//	
	
}
