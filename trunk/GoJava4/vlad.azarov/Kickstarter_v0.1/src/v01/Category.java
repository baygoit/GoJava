package v01;

import java.util.Scanner;

public class Category {
	
	private int selection;
	
	public static void showCategoryList() {
		int selection;
	    System.out.println("=============================");
	    System.out.println("| Category:                 |");
	    System.out.println("|        1. Art             |");
	    System.out.println("|        2. Film & Video    |");
	    System.out.println("|        3. Games           |");
	    System.out.println("|        4. Music           |");
	    System.out.println("|        5. Technology      |");
	    System.out.println("|        0. Exit            |");
	    System.out.println("=============================");
	    
	    System.out.print("Select some category: ");
	    Scanner scanner = new Scanner(System.in);
	    selection = scanner.nextInt();
	    
	    switch (selection) {
	    case 1:
	    	System.out.println("You choose Art category!");
	      	break;
	    case 2:
	    	System.out.println("You choose Film & Video category!");
	    	break;
	    case 3:
			System.out.println("You choose Game category!");
			break;
	    case 4:
			System.out.println("You choose Music category!");
			break;
	    case 5:
			System.out.println("You choose Technology category!");
			break;
	    case 0:
	    	System.out.println("Exit");
	    	break;
	    default:
	    	System.out.println("Invalid selection");
	    	break;
	    }
	    
	    System.out.println();
	    
		}
}
