package ua.com.goit.gojava1;

import java.util.ArrayList;
import java.util.Scanner;

public class Players {

 //Why static? 
  //GOOGLE: Encapsulation (object-oriented programming)
		static String [] bestPlayers = {"Michael Jordan", "Larry Bird", "Magic Johnson", "Wilt Chambelain", "John Stockton", "Moses Malobe", "Bob Cousy", "Kareem Abdul-Jabbar", "Julius Erving", "Karl Malone", "Pete Maravich", "Hakeem Olajuwon", "Shaquille O'Neal", "Bill Russell", "Jerry West"};  
		int i;
		ArrayList toplist = new ArrayList(); 
		
		
		public void addPlayers (String[] bestPlayers){
			//System.out.println("Members of Hall of fame");
			for (i=0; i<bestPlayers.length; i++){
				toplist.add(bestPlayers[i]);
			}
				
		}
		
		public void outputPlayers () {
			System.out.println("\n");
	        for(int i=0;i<toplist.size();i++){
	        System.out.println((i + 1) + ":" + toplist.get(i));
	    } 
	        }
		
		public void findPlayer (){
			System.out.println("Please enter Surname of your favorite player to check it in Hall of Fame:");
			Scanner scan = new Scanner(System.in);
			String input1=scan.next().trim();
			System.out.println("Please enter Name");
			String input2=scan.next().trim();
			String input = new String(input2 + " " + input1);
			System.out.println(input);
			   for (int counter=0; counter<toplist.size()-1; counter++) { 
			       if (toplist.contains(input)) {
			           System.out.println("Good choice");
			           break;
			      }
			       else{
			    	   System.out.println("Sorry, your player is not so legendary");
			    	   break;
			       }
			       }
			   }
		
     
		public void showList (){
			String correct = "Yes";
			System.out.println("Please type <Yes> if you want to see full list of Hall of Fame and press <Enter> ?");
			Scanner scan1 = new Scanner(System.in);
			String input=scan1.next().trim();
			if (correct.equals(input)) {
				outputPlayers();
			}
			else{
				System.out.println("Please type <Yes> ");
			}
			
		}
}
