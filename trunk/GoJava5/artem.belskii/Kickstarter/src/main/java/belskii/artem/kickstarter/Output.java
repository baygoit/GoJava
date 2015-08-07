package belskii.artem.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import belskii.artem.kickstarter.dao.project.Project;

public class Output {
	
	public void show(String line){
		System.out.println(line);
	}
	
	public void showCategory (Map<Integer, String> categoryList){
		for (int i = 0; i<categoryList.size(); i++){
			System.out.println(i+1+": "+categoryList.get(i));
		}
		System.out.println("Please select category number, and press Enter, or put 0 for exit:");
	}

	public void showProjectList(Map<Long, Project> projectList) {
		for (long i = 0; i<projectList.size();i++){
			System.out.println(i+1+": "+projectList.get(i).getName());
			System.out.println("Please select project number, and press Enter, or put 0 for return to home page:");
		}
	}

	public void showProjectDetails(Project project) {
		System.out.println("Project name: ");
		System.out.print(project.getName());
		System.out.print(" Project details: ");
		System.out.print(project.getDetails());
		System.out.print(" Current balans: ");
		System.out.print(project.getBalance());
		System.out.print(" Goal: ");
		System.out.print(project.getGoal());
		System.out.print(" Stard date: : ");
		System.out.print(project.getStartDate());
		System.out.print(" End Date: ");
		System.out.print(project.getEndDate());
		System.out.print(" You can see promo video on url: ");
		System.out.println(project.getVideoUrl());
		System.out.println("FAQ:");
		if(project.getFaq().size()<1){
			System.out.println("You can asq first question!");
		}
		for (long i=0; i<project.getFaq().size();i++){
			ArrayList<String> question = project.getFaq().get(i);
			System.out.println("Q: "+question.get(0));
			System.out.println("A: "+question.get(1));
			
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	    	System.out.println("Sorry, I can't clean your console :(");
	    	System.out.println(e);
	    }
	}

	public void showPaymentVariants(HashMap<Long, HashMap<Long, String>> paymentVariants) {
		for (long i=0; i<paymentVariants.size(); i++){
			Object[] value = paymentVariants.get(i).keySet().toArray();
			Object[] bonus = paymentVariants.get(i).values().toArray();
			System.out.println(i+1+": Payment amount "+value[0]+" bonus: "+bonus[0]);
		} 
		
	}
}
