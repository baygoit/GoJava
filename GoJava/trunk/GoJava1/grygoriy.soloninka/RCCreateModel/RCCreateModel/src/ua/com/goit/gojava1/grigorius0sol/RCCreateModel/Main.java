package ua.com.goit.gojava1.grigorius0sol.RCCreateModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static Model model  = new Model();
	static List<String> detailsList = model.getDetails().getDetailsList();
	
	public static void main(String args[]){

		System.out.println("Welcome to RC Model constructor.");
		
		for(int i = 1; i < detailsList.size(); i++){
			
			System.out.println(i + " " + detailsList.get(i));
		}
		System.out.println();
		System.out.println("Please choose the number to view the list of available details for each type.");
		List<String> detailedList = viewDetailedList();
		System.out.println();
		for(String name: detailedList){
			
			System.out.println(name);
		}
		System.out.println("Thank you for choosing our service.Good bye ^_^");
	}
	
	
	static private List<String> viewDetailedList(){
		
		List<String> result = new ArrayList<String>();
		Integer detailID;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			detailID = Integer.parseInt(reader.readLine());

			if(detailID >= 0 && detailID <= detailsList.size() ){
				
				switch(detailID){
					
				 	case 0 : 
				 		result = model.getDetails().getKit();
				 		break;
				 		
				 	case 1 : 
				 		result = model.getDetails().getWheels();
				 		break;
				 		
				 	case 2 : 
				 		result = model.getDetails().getRemote();
				 		break;
				 		
				 	case 3 : 
				 		result = model.getDetails().getEngine();
				 		break;
				 		
				 	case 4 : 
				 		result = model.getDetails().getServo();
				 		break;
			
				 	default:
				 		break;
				}
			}else{
				result = model.getDetails().getDefaultSet();
				
			}
		}catch (NumberFormatException e) {
			
			System.out.println("Invalid entry. Please retry again.");
			result = viewDetailedList();
			//e.printStackTrace();
			
		}catch (IOException e) {
			
			System.out.println("Invalid entry. Please retry again.");
			result = viewDetailedList();
			e.printStackTrace();
		}
		
		return result;
		
	}
}
