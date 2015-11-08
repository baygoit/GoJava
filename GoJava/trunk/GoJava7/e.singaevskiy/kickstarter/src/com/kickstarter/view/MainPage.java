package com.kickstarter.view;

import java.util.List;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;

public class MainPage {
	
	public void showQuote(Quote quote){
		System.out.println("\"" + quote.getText() + "\" - " + quote.getAuthor() + "\n");
	}

	public void showCategories(List<Category> categories){
		System.out.print("Categories: | ");

		for (int i = 1; i <= categories.size(); i++) {
			System.out.print("" + i + ". " + categories.get(i-1).getName() + " | ");
		}
		showExit();
	}
	
	public void showProjects(List<Project> projects){
		for (int i = 1; i <= projects.size(); i++) {
			Project project = projects.get(i-1);
			System.out.println(i + ". " + project);
			System.out.println("\t" + "Goal: " + project.getGoalSum() 
				+ "; Balance: " + project.getBalanceSum()
				+ "; Days left: " + project.daysLeft());
		}
		showExit();
	}
	
	public void showProjectDetails(Project project){
		System.out.println(project);
		System.out.println(project.getDescription());
		System.out.println("Goal: " + project.getGoalSum());
		System.out.println("Balance: " + project.getBalanceSum());
		System.out.println("Days left: " + project.daysLeft());
		System.out.println("Video: " + project.getVideoUrl());
		System.out.println("FAQ:");
		project.getQuestionsAndAnswers().stream()
			.map(faq -> "\t" + faq.toString())
			.forEach(System.out::println);
		showExit();
	}
	
	private void showExit(){
		System.out.println("0. Exit");
	}
	
	public void showDivider(){
		System.out.println("------------------------------------------");
	}
	
	public void showMessage(String message){
		System.out.println(message);
	}
	
}
