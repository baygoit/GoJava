package com.kickstarter.util;

import java.util.List;
import java.util.Map;

import com.kickstarter.app.Kickstarter;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public class ConsolePrintView {

	public void allCategoriesView(List<Category> list) {
//		 int i = 1;
//		 list.forEach((category)->System.out.println(i + "\t->" +
//		 list.get(i)));
//		 i++;
     	for (int i = 1; i < list.size(); i++) {
		System.out.println(i + "\t->" + list.get(i));
	}
	}

	public void categorySelectionInform() {
		System.out.println("\nPlease choose category you'd like to see: ");
	}

	public void selectedCategoryInformer(String title) {
		try {

			System.out.println("You have choosen " + title + "\n");
		} catch (Exception e) {
			System.out.println("There is no such number of Category available");
			Kickstarter.categorySelector();
		}
	}

	public void categorysProjectsView(Map<Integer, Project> projectList) {
		if (projectList.size() == 1) {
			for (Project p : projectList.values()) {
				System.out.println("Project Title : " + p.getTitle() + "\n Project Discription :" + p.getDiscription()
						+ "\n Project History : " + p.getProjectHistory() + "\n Video Link : " + p.getVideoLink()
						+ "\n Required Sum :" + p.getRequiredSum() + "\n Gained Sum :" + p.getGainedSum()
						+ "\n Days Left :" + p.getDaysLeft() + "\n");
			}
		} else {
			for (Project p : projectList.values()) {
				System.out.println("Project Title : " + p.getTitle() + "\n Project Discription :" + p.getDiscription()
						+ "\n Required Sum :" + p.getRequiredSum() + "\n Gained Sum :" + p.getGainedSum()
						+ "\n Days Left :" + p.getDaysLeft() + "\n");
			}
		}
	}

	public void programExitInform() {
		System.out.println("You hava left the program");
	}

	public void exitInformer() {
		System.out.println("If you`d like to return to previous menu, please input 0 sign");
	}

	public void projectSelectionInform() {
		System.out.println("\n" + "Choose project :");

	}

	public void choosenProjectTitleInform(String title) {
		System.out.println("You hava selected project -> " + title);

	}

	public void posobilitiesInfirm() {
		System.out.println(
				"You can donate ti this projec. If you'd lile to, please input 200,  \n or you can return to project selecrion menu presing any button ");

	}

	public void InputPayersNameInfo() {
		System.out.println("Please input your Name : ");
	}

	public void InputCardIdInfo() {
		System.out.println("Please input your card number : ");
	}

	public void paymentSizeInfo() {
		System.out.println("Please input amount of payment : ");
	}

	public void singleCategorysProjectsView(Project p) {
		System.out.println("\nProject Title : " + p.getTitle() + "\n Project Discription :" + p.getDiscription()
				+ "\n Project History : " + p.getProjectHistory() + "\n Video Link : " + p.getVideoLink()
				+ "\n Required Sum :" + p.getRequiredSum() + "\n Gained Sum :" + p.getGainedSum() + "\n Days Left :"
				+ p.getDaysLeft() + "\n QustionSection : " + p.getQuestionSection());
	}

	public void viewSelectedCategoryProjects(Map<Integer, Project> projectList) {
		int i = 1;
		for (Project p : projectList.values()) {
			System.out.println("Press " + i + " to select -> " + p.getTitle());
			i++;
		}

	}

	public void qoutePrint(String quote) {
		System.out.println(quote);
	}
	public void InputQuestionInfo(){
		System.out.println("Plese enter your quastion : ");
	}
}