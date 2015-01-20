package economicalEfficiency;

import java.util.HashMap;
import java.util.Map;

public class UnitDatabase {
	Map<String,ProductionUnit> unit = new HashMap<>();
	
	public void add(){
	System.out.println("add new unit to database");
	ProductionUnit newUnit = new ProductionUnit();
	unit.put(newUnit.name,newUnit);
	}

	public void remove(String name) {
		unit.remove(name);
		
	}
}
