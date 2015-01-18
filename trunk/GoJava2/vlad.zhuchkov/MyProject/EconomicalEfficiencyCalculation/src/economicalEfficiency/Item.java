package economicalEfficiency;

import java.util.Scanner;

public class Item {
	String name;
	double price;
	int quantity;
		
	Item(){
		Scanner sc = new Scanner(System.in);
		System.out.print("name of item\n");
		name = sc.nextLine();
		System.out.print("it's price\n");
		price = Integer.valueOf(sc.nextLine());
		System.out.print("it's quantity\n");
		quantity = Integer.valueOf(sc.nextLine());
	
		}
	public double getMyValue(){
		return price*quantity;
	}

}
