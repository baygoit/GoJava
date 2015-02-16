package ua.goit.goitjava.kickstarter;

//import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Output out = new Output();
		out.printQuote();
		//out.menu();
		
		Category cat1 = new Category("Education");
		Category cat2 = new Category("Finance");
		Category cat3 = new Category("Game");
		
		
		Categories cats1 = new Categories();
		cats1.addCategory(cat1);
		cats1.addCategory(cat2);
		cats1.addCategory(cat3);
		
		
		Projects projects = new Projects();
		Project englishTeacher = new Project("English teacher", "Virtual english teacher", cats1.getCategoryByIndex(0), 10000, 300, 120,
				"Projects idea came a year ago", "www.videolink/englishTeacher", 
				"Quation&Answer\n I programmer. Can I participate in the project?\n No thanks" );
		projects.addProject(englishTeacher);
		
		Project mathTeacher = new Project("Mathematics teacher","Virtual mathematics teacher", cats1.getCategoryByIndex(0),15000,5000,60,
				"Projects idea came a year ago", "www.videolink/englishTeacher", 
				"Quation&Answer\n I programmer. Can I participate in the project?\n No thanks");
		projects.addProject(mathTeacher);
		
		Project homeAccountant = new Project("Home accountent","Virtual accountant", cats1.getCategoryByIndex(1),20000,2000,253,
				"Projects idea came a year ago", "www.videolink/englishTeacher", 
				"Quation&Answer\n I programmer. Can I participate in the project?\n No thanks");
		projects.addProject(homeAccountant);
		
		Project companyAccountant = new Project("Company accountant","Virtual company accountent", cats1.getCategoryByIndex(1),50000,20000,126,
				"Projects idea came a year ago", "www.videolink/englishTeacher", 
				"Quation&Answer\n I programmer. Can I participate in the project?\n No thanks");
		projects.addProject(companyAccountant);
		
		while (true) {
			out.printMenu(cats1);			
			Input in = new Input();
			Category category = null;
			int x;
			
			x = in.scanInt();
			while(true){
				
				if(x != 0){
				category = cats1.getCategoryByIndex(x-1);
				out.youChoose(category.getName());
				ArrayList<Project> projectsByCategory = projects
						.getProjectsByCategory(category);
				out.printProject(projectsByCategory);
				out.printZero();
				
				} else {
					break;
				}
				
				x = in.scanInt();
				while(true){
					
					if(x != 0){
						category = cats1.getCategoryByIndex(x-1);
						/*if(projectId1 == 0){
							break;
						}*/
						ArrayList<Project> projectsByCategory = projects
								.getProjectsByCategory(category);
						out.printSelectProject(projectsByCategory.get(x - 1));
						System.out.println("==========================");
						out.printZero();
						x = in.scanInt();
					} else {
						break;
					}
					//continue;
				}
			}				
		}

	}

}
