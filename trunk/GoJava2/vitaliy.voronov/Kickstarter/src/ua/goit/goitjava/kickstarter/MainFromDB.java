package ua.goit.goitjava.kickstarter;

import java.util.ArrayList;

public class MainFromDB {
public static void main(String[] args) {
		
		ProjectService pr = new ProjectService();
		CategoryService cat = new CategoryService(); 
		Output out = new Output();
		out.printQuote();
		//out.menu();
		
		
		while (true) {
			cat.showAllCategories();	
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
				//category = cats1.getCategoryByIndex(x-1);
				cat.printCategoryByID(x);
				pr.showProjectByCategory(x);
				out.printZero();
				
				
				
				x = in.scanInt();
				while(true){
					if(x == 0){
						break;
					}
						cat.printCategoryByID(x);
						out.printZero();
						pr.showProjectByID(x);//TODO 
						System.out.println("1) Ask a quation\n2) Invest money\n3) Choose a prize for investing");
						int y = in.scanInt();
						switch (y){
						/*case 1:
							System.out.println("¬ведите вопрос");
							String s = in.scanLine();
							//projectsByCategory.get(x - 1).addFAQ(new FAQ(s,null));
							break;
						case 2:
							System.out.println("¬ведите »м€");
							String sOs = in.scanLine();
							System.out.println("¬ведите є карты");
							String gyGY = in.scanLine();
							System.out.println("¬ведите сумму");
							int sum = in.scanInt();
							//projectsByCategory.get(x - 1).addMoney(sum);
							break;*/
						/*case 3:
							System.out.println("1 - 10$(you will get a thank)\n2 - 100$(you get a big thank)"
									+ "\n3 - 1000$(you get a very big thank)\n4 - 100000$(you get a Chupa Chups :) ");
							int choise = in.scanInt();
							switch(choise){
							case 1:
								projectsByCategory.get(x - 1).addMoney(10);
								System.out.println("Thank you");
								break;
							case 2:
								projectsByCategory.get(x - 1).addMoney(100);
								System.out.println("Thank you very mach");
								break;
							case 3:
								projectsByCategory.get(x - 1).addMoney(1000);
								System.out.println("Thank you very very mach");
								break;
							case 4:
								System.out.println("Your Chupa Chups, we will send by Ukrpochta :)");
								projectsByCategory.get(x - 1).addMoney(100000);
								
								break;
							}*/
						//break;
							
						}
					} 
				}
			}				
		}
}
