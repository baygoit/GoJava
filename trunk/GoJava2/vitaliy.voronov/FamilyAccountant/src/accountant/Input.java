package accountant;

import java.util.Scanner;

public class Input {
	public int choise(){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		return a;
	}
	
	public static String name(){
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		return name;
	}
	
	public static int price(){
		Scanner scan = new Scanner(System.in);
		int price = scan.nextInt();
		return price;
	}

}
