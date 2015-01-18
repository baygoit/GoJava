import java.util.ArrayList;


public class Visited {
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void addCountry(String country){
		list.add(country);
	}
	
	public static void showCountries(){
		for (int i =0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
