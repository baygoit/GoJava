package economicalEfficiency;

import java.util.HashMap;
import java.util.Map;

public class FactoryDatabase {
Map<String,Factory> factory = new HashMap<>();
	
	public void add(){
	Factory newFactory = new Factory();
	factory.put(newFactory.name,newFactory);
	}
}
