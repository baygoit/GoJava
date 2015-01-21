
public class Production {
	double price;
	String name;
	int kilkist;
	
	public void calc(){
		System.out.println("Name:"+ name + " Price: "+ price + " Kilkist: " + kilkist + 
				           "\n" + " You have to pay: " + price*kilkist);
	}
	
	
}
