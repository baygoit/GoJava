package rent;

import java.util.ArrayList;

public class ListItems {
	public static void getItem(Item i){
		System.out.println(Item.getTitle(i) + " - " + Item.getPrice(i) + "grn/day: " + Item.getDescription(i));
	}
	
	public static void listItems() {
		for (int i = 0; i < Catalog.items.size(); i++) {
			getItem(Catalog.items.get(i));
		}
}}
