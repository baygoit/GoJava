package economicalEfficiency;

import java.util.Scanner;

public class Item {
	String name;
	double price;
	int quantity;
		
	public void set(String role){
		Scanner sc = new Scanner(System.in);
		System.out.print("name of "+role+" \n");
		name = sc.nextLine();
		System.out.print("it's price\n");
		price = Integer.valueOf(sc.nextLine());
		if(role=="product")
			System.out.print("How many product does it produce per cycle?\n");
		else if (role=="resorse")
			System.out.print("How many resorses does it need per cycle?\n");
		sc.close();
		}
	public double getMyValue(){
		return price*quantity;
	}

}
