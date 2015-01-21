
public class Country {
	String name;
	int count;
	String color;
	
	public void setName(String name){ this.name=name;}
	
	public void setCount(){	count++;}
	
	public void increaseCount(){	count++;}
	
	public void setColor(String color){ this.color=color;}
	
	public String getName(){ return name;}
	
	public int getCount(){ return count;}
	
	public String getColor(){ return color;}
	
	public static void showCountry(Country country){
		System.out.println(country.getName() + " " + country.getCount() + " times"); 
	}
	
	public static Country addNewCountry(String name){
		Country newCountry = new Country();
		newCountry.setName(name);
		newCountry.increaseCount();
		return newCountry;
	}
}
