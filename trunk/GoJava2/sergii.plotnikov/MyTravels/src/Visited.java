import java.util.ArrayList;


public class Visited {
	static ArrayList<Country> list = new ArrayList<Country>();
	
	public static void addCountry(String name){
		list.add(Country.addNewCountry(name));
	}
	
	public static void showCountries(){
		for (int i =0; i<list.size(); i++){
			Country.showCountry(list.get(i));
		}
	}
	
	public static void checker(String name){
		int check = 0;
		for (int i = 0; i<list.size(); i++){
			if(list.get(i).getName()==name){
				list.get(i).increaseCount();
				check++;
			}
		}
		if(check==0){
			list.add(Country.addNewCountry(name));
		}
	}

}
