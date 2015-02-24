package gojava.InMemory;
import gojava.Interface.Category;
import gojava.Interface.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class InMemoryCategory implements Category {
	private ArrayList<InMemoryProject> projectsList = new ArrayList<InMemoryProject>();
	private String title;
	
	public InMemoryCategory(String title){ this.title=title;}

	public String getTitle(){ return title;}

	@Override
	public String showProjects() {
		if(projectsList.size()==0){
			return "Empty!\n0 - Go back";
		}
		
		String result ="You have chosen Category "+
							getTitle()+"\nChoose a project:\n";
		int num = 1;
		for(int i = 0; i<projectsList.size(); i++){
			result+=num + " - " + getProject(i).shortProjectDescr();
			num++;
		}
		result+="0 - Go back\n";
		
		return result;
	}

	@Override
	public Project getProject(int i){
		return projectsList.get(i);
	}

	@Override
	public int getLength(){
		return projectsList.size();
	}

	@Override
	public void addProject(String string) {
		projectsList.add(new InMemoryProject(string));
		Collections.sort(projectsList, new Comparator<InMemoryProject>() {
	        @Override
	        public int compare(InMemoryProject cat1, InMemoryProject cat2)
	        {
	            return  cat1.getTitle().compareTo(cat2.getTitle());
	        }			
	    });
	}
}
