package economicalEfficiency;

import java.util.Scanner;

public class Unit {
	String name;
	Item product;
	int price;//dolars
	int quantityOfWorkers;
	Worker worker;
	int timeOfCycle; //seconds
	int quantity;
	
	Unit(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Input name of unit\n");
		name = sc.nextLine();
		System.out.print("Input it's price\n");
		price = Integer.valueOf(sc.nextLine());
		System.out.print("How many workers does it need?\n");
		quantityOfWorkers = Integer.valueOf(sc.nextLine());
		System.out.print("set worker's propertys\n");
		worker = new Worker();
		System.out.print("How long does one cycle last?\n");
		timeOfCycle = Integer.valueOf(sc.nextLine());
		System.out.print("What product does it produce?\n");
		product = new Item();
		System.out.println("Quantity of units");
		quantity = Integer.valueOf(sc.nextLine());
		
	}
	
	public double getProductivity(){
		return product.quantity/quantityOfWorkers;
	}
}
