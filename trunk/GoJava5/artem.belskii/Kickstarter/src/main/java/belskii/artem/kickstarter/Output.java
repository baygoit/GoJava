package belskii.artem.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import belskii.artem.kickstarter.dao.project.Project;

public class Output {
	
	public void show(String line){
		System.out.println(line);
	}
	
	public void showCategory (HashMap<Integer, String> CategoryList){
		for (int i = 0; i<CategoryList.size(); i++){
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(CategoryList.get(i));
			strBuilder.append(": ");
			strBuilder.append(CategoryList.get(i));
			System.out.println(strBuilder.toString());
		}
		System.out.println("Please select category number, and press Enter, or put 0 for exit:");
	}

	public void showProjectList(HashMap<Long, Project> projectList) {
		for (long i = 0; i<projectList.size();i++){
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(i+1);
			strBuilder.append(": ");
			strBuilder.append(projectList.get(i).getName());
			System.out.println(strBuilder.toString());
			System.out.println("Please select project number, and press Enter, or put 0 for return to home page:");
		}
	}

	public void showProjectDetails(Project project) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Project name: ");
		strBuilder.append(project.getName());
		strBuilder.append(" Project details: ");
		strBuilder.append(project.getDetails());
		strBuilder.append(" Current balans: ");
		strBuilder.append(project.getBalance());
		strBuilder.append(" Goal: ");
		strBuilder.append(project.getGoal());
		strBuilder.append(" Stard date: : ");
		strBuilder.append(project.getStartDate());
		strBuilder.append(" End Date: ");
		strBuilder.append(project.getEndDate());
		strBuilder.append(" You can see promo video on url: ");
		strBuilder.append(project.getVideoUrl());
		System.out.println(strBuilder.toString());
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
			StringBuilder strBuilder = new StringBuilder();
			Object[] value = paymentVariants.get(i).keySet().toArray();
			Object[] bonus = paymentVariants.get(i).values().toArray();
			strBuilder.append(i+1);
			strBuilder.append(": Payment amount ");
			strBuilder.append(value[0]);
			strBuilder.append(" bonus: ");
			strBuilder.append(bonus[0]);
			//strBuilder.append(paymentVariants.get(i).values());
			System.out.println(strBuilder.toString());
		} 
		
	}
}
