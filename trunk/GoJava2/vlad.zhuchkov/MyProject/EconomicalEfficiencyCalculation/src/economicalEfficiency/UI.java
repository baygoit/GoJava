package economicalEfficiency;

import java.util.Scanner;

public class UI {
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		String option="yes";
		FactoryDatabase database = new FactoryDatabase();
		while(option=="yes"){
			System.out.println("select option(1-4):");
			System.out.println("1) Create new factory");
			System.out.println("2) Edit factory");
			System.out.println("3) Get Statistics");
			System.out.println("4) Simulation");
			option=sc.nextLine();
			switch(option){
			case "1":{
				database.add();
				break;
			}
			case "2":{
				System.out.println("enter name of factory");
				for (Factory value : database.factory.values())
					System.out.print(value.name+" ");
				String turget = sc.nextLine();
				Factory tempF = database.factory.get(turget);
				System.out.println("select option(1-4):");
				System.out.println("1)cange number of unit");
				System.out.println("2)cange cost of product");
				System.out.println("3)cange worker's pay");
				option = sc.nextLine();
				switch(option){
					case "1":{				
						System.out.println("enter name of unit");
						turget = sc.nextLine();
						tempF.cangeNumberOfUnit(turget);
						break;
					}
					case "2":{
						System.out.println("enter name of unit");
						turget = sc.nextLine();
						tempF.cangeCostOfProduct(turget);
						break;
					}
					case "3":{
						tempF.cangeWorkersPay();
						break;
					}
				}
				break;
				
			}
			case "3":{
				for (Factory value : database.factory.values())
					System.out.print(value.name+" ");
				System.out.println("choose factory");
				String turget = sc.nextLine();
				Factory tempF = database.factory.get(turget);
				tempF.getStatistics();
				break;
			}
			case "4":{
				//TODO 
				break;
			}
			}
		System.out.println("do you whant to do something else? yes/no");
		option=sc.nextLine();
		
		}
		sc.close();
	}
}