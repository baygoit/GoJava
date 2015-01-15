package economicalEfficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductionUnit {
	String name;
	Item product;
	int price;//dolars
	int quantityOfWorkers;
	int timeOfCycle; //seconds
	int quantityOfResorses;
	ArrayList<Item> resorses = new ArrayList<>();
	
	
	public void set(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Input name of prodaction unit\n");
		name = sc.nextLine();
		System.out.print("Input it's price\n");
		price = Integer.valueOf(sc.nextLine());
		System.out.print("How many workers does it need?\n");
		quantityOfWorkers = Integer.valueOf(sc.nextLine());
		System.out.print("How many product does it produce per cycle?\n");
		Item product = new Item();
		product.quantity = Integer.valueOf(sc.nextLine());
		System.out.print("How long does one cycle last?\n");
		timeOfCycle = Integer.valueOf(sc.nextLine());
		System.out.print("What product does it produce?\n");
		product = new Item();
		product.set("product");
		System.out.print("How many types of resurses does it need\n");
		quantityOfResorses=Integer.valueOf(sc.nextLine());
		System.out.print("What resorses?\n");
		for (int i=0;i<quantityOfResorses;i++){
			System.out.print("resorse ¹ "+i+1+"\n");
			Item resorse = new Item();
			resorse.set("resorse");
		}
		sc.close();
	}
		
	public double getProductivity(){
		return product.quantity/quantityOfWorkers;
	}
	public double getCostOfAllResorses(){
		double cost=0;
		for (int i=0;i<quantityOfResorses;i++)
		cost+=resorses.get(i).getMyValue();	
		return cost;
	}
	
	
}
