package economicalEfficiency;

import java.util.HashMap;
import java.util.Map;

public class ItemDatabase {
	Map<String,Item> item = new HashMap<>();
	
	public void add(){
	System.out.println("add new item to database");
	Item newItem = new Item();
	item.put(newItem.name,newItem);
	}

}
