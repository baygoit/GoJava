import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	private static String motivator = "Get involved in the development of interesting projects!";
	static final String SPACE = " ";
	private static Scanner scan;
	
	public static void main(String[] args){
		
		System.out.println(motivator);
		System.out.println(SPACE);
		
		HashMap<String, String> listCategory = new HashMap<String, String>();
		
		listCategory.put("1", "Game");
		listCategory.put("2", "Design");
		listCategory.put("3", "Technology");
		listCategory.put("4", "Fashion");
		listCategory.put("5", "Crafts");
		listCategory.put("6", "Comics");
		listCategory.put("7", "Theater");
		listCategory.put("8", "Publishing");
		listCategory.put("9", "Music");
		
		HashMap<String, String> listProgect = new HashMap<String, String>();
		
		listProgect.put("Game", "progect 1, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Game", "progect 2, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Game", "progect 3, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Design", "progect 4, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Design", "progect 5, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Design", "progect 6, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Technology", "progect 7, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Technology", "progect 8, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Technology", "progect 9, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Fashion", "progect 10, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Fashion", "progect 11, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Fashion", "progect 12, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Crafts", "progect 13, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Crafts", "progect 14, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Comics", "progect 15, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Comics", "progect 16, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Comics", "progect 17, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Theater", "progect 18, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Theater", "progect 19, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Theater", "progect 20, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Publishing", "progect 22, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Publishing", "progect 23, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Publishing", "progect 24, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Music", "progect 25, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Music", "progect 26, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		listProgect.put("Music", "progect 27, description, amount required = 1000$, compiled = 220$, hours to go = 10");
		
		
		HashMap<String, String> listProgectDetaul = new HashMap<String, String>();
		
		listProgectDetaul.put("progect1", "progect 1, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect2", "progect 2, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect3", "progect 3, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect4", "progect 4, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect5", "progect 5, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect6", "progect 6, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect7", "progect 7, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect8", "progect 8, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect9", "progect 9, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect10", "progect 10, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect11", "progect 11, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect12", "progect 12, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect13", "progect 13, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect14", "progect 14, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect15", "progect 15, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect16", "progect 16, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect17", "progect 17, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect18", "progect 18, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect19", "progect 19, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect20", "progect 20, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect22", "progect 22, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect23", "progect 23, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect24", "progect 24, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect25", "progect 25, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect26", "progect 26, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		listProgectDetaul.put("progect27", "progect 27, detailed description, amount required = 1000$, compiled = 220$, hours to go = 10, project history, link");
		
		HashMap<Integer, String> listProgectResult = new HashMap<Integer, String>();
	
		for (Map.Entry<String, String> pair : listCategory.entrySet()){
			String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ") " + value);
        }
		
		System.out.println(SPACE);
		
		scan = new Scanner(System.in);
		String valueGet = scan.nextLine();
		int i = 0;		
		
		for (Map.Entry<String, String> pair : listCategory.entrySet()){
			if( valueGet.equals(pair.getKey())){
				System.out.println(SPACE);
				System.out.println("You have chosen category " + pair.getValue());
				System.out.println(SPACE);
				System.out.println("List progect");
				System.out.println(SPACE);
				
				for (Map.Entry<String, String> pair1 : listProgect.entrySet()){
					i++;
					System.out.println(i + ") " + pair1.getValue());					
					listProgectResult.put(i, a);  	 	  		
				}
			}
        }

		System.out.println(SPACE);
		System.out.println("Choose a project");
		System.out.println(SPACE);
		
		scan = new Scanner(System.in);
		int valueGet1 = Integer.parseInt(scan.nextLine());
				
		for (Map.Entry<Integer, String> pair4 : listProgectResult.entrySet()){
			if( valueGet1 == (pair4.getKey())){
				System.out.println("Progect details");
				System.out.println(SPACE);
				System.out.println(pair4.getValue());				
			}
        }
		
		System.out.println("Choose a project");
		System.out.println(SPACE);
		System.out.println("Select '0' Back to the category list");
		
		scan = new Scanner(System.in);
		int valueGet2 = Integer.parseInt(scan.nextLine());
		
		if(valueGet2 == 0){
			for (Map.Entry<String, String> pair : listCategory.entrySet()){
				String key = pair.getKey();
	            String value = pair.getValue();
	            System.out.println(key + ") " + value);
	        }
		}else{
			System.out.println("No number");
		}
		
		
	}
}
