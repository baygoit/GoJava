package com.goit.io;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.goit.logic.Menu;
import com.goit.logic.Category;
import com.goit.logic.DaysCounter;
import com.goit.logic.Project;

public class PageReaderImpl implements PageReader {

	public final static String EXIT = "exit";

	private static Menu menu = new Menu();
	private static MenuFileReader menuFileReader;
	private static Category category = new Category();
	private static CategoryFileReader categoryFileReader;
	private static Project project = new Project();
	private static ProjectFileReader projectFileReader;
	
	

	private ArrayList<String> categoryList;

	@Override
	public void showMenu(String menuPath, String quotePath) {
		menuFileReader = new MenuFileReader(menuPath, quotePath);
		try {
			menu = menuFileReader.getMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String quote = menu.getQuote();
		System.out.println(markString(quote, "="));
		String welcome = "Enter the number of category";
		System.out.println(markString(welcome, "-"));

		categoryList = new ArrayList<String>();
		categoryList = menu.getCategories();
		for (int index = 1; index < categoryList.size(); index++) {
			System.out.println("[" + index + "] " + categoryList.get(index));
		}
		System.out.println("[" + 0 + "] " + categoryList.get(0));

	}

	private ArrayList<String> projectList;
	
	public void setProjectList(int numberCategory){
		categoryFileReader = new CategoryFileReader("data/" + categoryList.get(numberCategory) + ".txt");
		try {
			category = categoryFileReader.getCategory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		projectList = category.getListProjects();
	}

	@Override
	public void showCategory(int numberCategory) {
		setProjectList(numberCategory);
		System.out.println(markString(category.getName(), "="));
		String enterProject = "Enter the number of project";
		System.out.println(markString(enterProject, "-"));
		for (int index = 1; index < projectList.size(); index++) {
			System.out.println("[" + index + "] " + projectList.get(index));
		}
		System.out.println("[0] " + projectList.get(0));

	}

	@Override
	public void showProject(int numberProject) {
		projectFileReader = new ProjectFileReader("data/" + projectList.get(numberProject) + ".txt");
		try {
			project = projectFileReader.getProject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(markString(project.getName(), "="));
		System.out.println("Description: " + lineBreak(project.getDescription(), 6));
		System.out.println("Link to video: " + "\n" + project.getLink());
		System.out.println("Goal: " + project.getNeedMoney() + "$");
		String precent = getPrecent(project.getAccumulatedMoney(), project.getNeedMoney());
		System.out.println("Collection: " + project.getAccumulatedMoney() + "$ - " + precent);
		DaysCounter counter = new DaysCounter();
		try {
			System.out.println("Days left: " + counter.getDays(project.getFinalDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String question = "Would you like to share money? - press [1] :)";
		System.out.println(markString(question, "-"));
		System.out.println("[0] " + EXIT);
	}
	
	public int getCategoryListSize(){
		return categoryList.size();
	}
	
	public int getProjectListSize(){
		return projectList.size();
	}

	private String markString(String words, String sign) {
		String divisor = sign;
		for (int index = 0; index < words.toCharArray().length - 1; index++) {
			divisor = divisor + sign;
		}
		divisor = "+" + divisor + "+";
		return divisor + "\n|" + words + "|\n" + divisor;
	}

	private String lineBreak(String text, int transfer) {
		String[] wordArray = text.split(" ");
		String outputText = "";
		for (int index = 0; index < wordArray.length; index++) {
			if ((index % transfer) == 0) {
				outputText = outputText + "\n";
			}
			outputText = outputText + wordArray[index] + " ";
		}
		return outputText;
	}

	private String getPrecent(int collected, int goal) {
		float result = ((float) collected * 100) / (float) goal;
		return String.format("%.2f", result) + "%";
	}

}
