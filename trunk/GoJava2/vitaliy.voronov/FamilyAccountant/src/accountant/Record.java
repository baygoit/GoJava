package accountant;

public class Record {
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void setName(){
		System.out.println("enter name");
		name = Input.name(); 
	}

	public void setPrice() {
		System.out.println("введите сумму");
		price = Input.price();
		
		
		
	}

}
