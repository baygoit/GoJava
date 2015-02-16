package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class GoodTypeDAO implements IDAO<GoodType> {
	
	List<GoodType> list;
	
	public GoodTypeDAO() {
		
		list = new ArrayList<GoodType>();		
		init();
		
	}

	@Override
	public void create(GoodType arg) {
		
		list.add(arg);

	}

	@Override
	public void update(GoodType arg) {

		for (GoodType type: list) {
			if (type.getId().equals(arg.getId())) {
				list.remove(type);
				list.add(arg);
				return;
			}
		}
		create(arg);
		
	}

	@Override
	public List<GoodType> getAll() {
		List<GoodType> result = new ArrayList<GoodType>();
		for (GoodType element :list){
			result.add(element);
		}
		return result;
		
	}

	private void init() {
		
		GoodType type = new GoodType();
		
		type.setId(1);
		type.setName("Guitars");
		type.setParent(null);
		list.add(type);
		GoodType guitars = type;
		
		type = new GoodType();			
		type.setId(2);
		type.setName("Keys");
		type.setParent(null);
		list.add(type);
		
		type = new GoodType();
		type.setId(3);
		type.setName("Amplifiers");
		type.setParent(null);
		list.add(type);
		
		type = new GoodType();
		type.setId(4);
		type.setName("Bass guitars");
		type.setParent(guitars);
		list.add(type);
	}
	
}
