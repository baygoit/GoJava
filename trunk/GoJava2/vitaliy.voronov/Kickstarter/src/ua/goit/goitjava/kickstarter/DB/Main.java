package ua.goit.goitjava.kickstarter.DB;


import java.util.ArrayList;

import ua.goit.goitjava.kickstarter.Category;
import ua.goit.goitjava.kickstarter.Input;

public class Main {
public static void main(String[] args) {
		
		Controller control = new Controller();
		View v = new View();
		v.printQuote();
		Project project = null;
		
		while (true) {
			control.showAllCategories();	
			Input in = new Input();
			Category category = null;
			int x;
			x = in.scanInt();
			if(x == 0){
				break;
			}
			while(true){
				if(x == 0){
					break;
				}				
				control.showCategoryByID(x);
				control.showProjectByCategory(x);
				v.showZero();
				int z = in.scanInt();
				while(true){
					if(x == 0){
						break;
					}
					    project = control.getSelectProgect(z, x);
						v.printSelectProject(project);
						v.showZero();
						System.out.println("1) Ask a question\n2) Invest money\n3) Choose a prize for investing");
						int y = in.scanInt();
						switch (y){
						case 1:
							System.out.println("¬ведите вопрос");
							String s = in.scanLine();
							break;
						case 2:
							System.out.println("¬ведите »м€");
							String sOs = in.scanLine();
							System.out.println("¬ведите є карты");
							String gyGY = in.scanLine();
							System.out.println("¬ведите сумму");
							int sum = in.scanInt();
							project.addMoney(sum);
							control.updateProject(project);
							break;
						case 3:
							System.out.println("1 - 10$(you will get a thank)\n2 - 100$(you get a big thank)"
									+ "\n3 - 1000$(you get a very big thank)\n4 - 100000$(you get a Chupa Chups :) ");
							int choise = in.scanInt();
							switch(choise){
							case 1:
								project.addMoney(10);
								control.updateProject(project);
								System.out.println("Thank you");
								break;
							case 2:
								project.addMoney(100);
								control.updateProject(project);
								System.out.println("Thank you very mach");
								break;
							case 3:
								project.addMoney(1000);
								control.updateProject(project);
								System.out.println("Thank you very very mach");
								break;
							case 4:
								System.out.println("Your Chupa Chups, we will send by Ukrpochta :)");
								project.addMoney(100000);
								control.updateProject(project);
								break;
							}
						break;
							
						}
					} 
				}
			}				
		}
}
