package ua.goit.goitjava.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
	
	ProjectDB projDB = new ProjectDB();
	Output out = new Output();
	
	public void showProjectByID(int id){
		Project p = projDB.getProjectByID(id);
		out.printSelectProject(p);
	}
	
	public void showProjectByCategory(int categoryId){
		out.printProject(projDB.getProjectByCategoriId(categoryId));
	}
	

}
