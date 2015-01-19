package rent;

import java.util.ArrayList;

public class Catalog {
	public static ArrayList<Item> items = new ArrayList<Item>();

	public Catalog() {
		items.add(new Item("Snowboard", 50, "Black with cool print!", false));
		items.add(new Item("Ski", 50, "White with cool print!", false));
		items.add(new Item("Laptop", 40, "Red with cool print!", false));

	}

//	public static void getItem(Item i){
//		System.out.println(Item.getTitle(i) + " - " + Item.getPrice(i) + "grn/day: " + Item.getDescription(i));
//	}
//	
//	public void listItems() {
//		for (int i = 0; i < items.size(); i++) {
//			getItem(items.get(i));
//		}
//}
}