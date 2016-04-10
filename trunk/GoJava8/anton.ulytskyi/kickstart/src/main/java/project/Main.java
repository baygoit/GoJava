package project;

import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		SQLLoader kickstarter = new SQLLoader();
	    try {
	    	
			List<String> p = kickstarter.getCategories();
			for(String c:p){
				System.out.println(c);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
	
	}

}
