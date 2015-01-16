/* Finance
 * 
 * Version 1.0
 *
 * Copyright by me)
 * 
 */

package ua.com.goit.gojava.alekspole.finance;
import java.util.ArrayList;

public class Finance {
	
	public static void main (String[] args){
		if (args.length == 0){ System.out.println("Please launch app with some key");
		return;
		}
		
		int key;										// Key variable application starts with  
		
		try { key = Integer.parseInt(args[0]); 
		} catch (NumberFormatException e) {
			throw new NumberFormatException ("Please input your key - either 1 or 2");
		  }
		
		showResults(key);
		
	}
		
	
	private static void showResults (int key){
		
		ArrayList<String> paramNames = new ArrayList<>();
		paramNames.add("Date");
		paramNames.add("CDSspread");
		
		ArrayList<ArrayList<String>> paramList = new ArrayList<>();
		paramList.add(new ArrayList<String>());
		paramList.add(new ArrayList<String>());
		
		paramList.get(0).add("2014-01-01");
		paramList.get(0).add("2014-01-02");
		paramList.get(0).add("2014-01-03");
		paramList.get(0).add("2014-01-04");
		paramList.get(1).add("15.3");
		paramList.get(1).add("15.9");
		paramList.get(1).add("16.2");
		paramList.get(1).add("16.5");
		
			if (key == 1) {
				for (int i = 0; i<paramNames.size(); i++){
					System.out.print(paramNames.get(i) + " | ");
				}
				
				System.out.println();
				
				int temp = paramList.get(0).size() - 1;
				
				for (int i = temp; i < paramList.get(0).size(); i++){
					System.out.println(paramList.get(0).get(i) + " | " + paramList.get(1).get(i));
				}	
			}
		
			if (key == 2) { 
				for (int i = 0; i<paramNames.size(); i++){
					System.out.print(paramNames.get(i) + " | ");
				}
				
				System.out.println();
				
				for (int i = 0; i < paramList.get(0).size(); i++){
					System.out.println(paramList.get(0).get(i) + " | " + paramList.get(1).get(i));
				}	
				
			
			}
		
	}
	
	

}
