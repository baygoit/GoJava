package project;

import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
	/**
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
		*/
		SQLLoader base = new SQLLoader();
		base.reload();
		List<String> projects = base.kickstarter.findProfile(1);
			
				for(String c:projects){
					System.out.println(c);
				}
			}
}