package accountant;

import java.util.Scanner;

public class Record {
	String name;
	int price;
	
	public void setName(){
		System.out.println("enter name");
		Scanner scan = new Scanner(System.in);
		name = scan.nextLine(); 
	}

	public void setPrice() {
		System.out.println("введите сумму");
		Scanner scan = new Scanner(System.in);
		price = scan.nextInt();
		
		
		
	}

}
