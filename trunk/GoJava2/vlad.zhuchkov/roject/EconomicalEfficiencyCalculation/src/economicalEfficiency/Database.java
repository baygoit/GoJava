package economicalEfficiency;

import java.util.HashMap;
import java.util.Map;

public class Database {
Map<ProductionUnit,String> unit = new HashMap<>();
Map<ProductionUnit,String> item = new HashMap<>();

	public void add(String turget){
		switch(turget)
		{
			case "unit":{
				System.out.println("add new unit to database");
				ProductionUnit newUnit = new ProductionUnit();
				newUnit.set();
				unit.put(newUnit, newUnit.name);
				break;
			}
			/*case "item":{
				System.out.println("add new item to database");
				Item newItem = new Item();
				newItem.setCharacteristics("");
				unit.put(pUnit, pUnit.name);
				break;
			}*/
			
		}
		
	}
}
