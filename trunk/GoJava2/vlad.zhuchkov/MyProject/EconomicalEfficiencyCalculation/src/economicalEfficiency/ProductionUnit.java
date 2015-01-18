package economicalEfficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductionUnit extends Unit {
	int quantityOfResorses;
	ArrayList<Item> resorses = new ArrayList<>();
		
	ProductionUnit(){
		super();
		Scanner sc = new Scanner(System.in);
		System.out.print("How many types of resurses does it need\n");
		quantityOfResorses=Integer.valueOf(sc.nextLine());
		System.out.print("What resorses?\n");
		for (int i=0;i<quantityOfResorses;i++){
			System.out.print("resorse ¹ "+i+1+"\n");
			Item resorse = new Item();
			resorses.add(resorse);
		}
		
	}
		
	
	public double getCostOfAllResorses(){
		double cost=0;
		for (int i=0;i<quantityOfResorses;i++)
		cost+=resorses.get(i).getMyValue();	
		return cost;
	}
	
	
}
