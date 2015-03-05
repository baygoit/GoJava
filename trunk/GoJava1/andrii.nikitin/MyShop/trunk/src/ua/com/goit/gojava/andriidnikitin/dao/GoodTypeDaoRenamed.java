package ua.com.goit.gojava.andriidnikitin.dao;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.IDAO;

public class GoodTypeDaoRenamed implements IDAO<GoodType> {
	
	List<GoodType> list;
	
	public GoodTypeDaoRenamed() {
		
		list = new ArrayList<GoodType>();		
		init();
		
	}

	@Override
	public boolean create(GoodType arg) {		
		return list.add(arg);
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
		
		type = new GoodType();
		type.setId(5);
		type.setName("Electro guitars");
		type.setParent(guitars);
		list.add(type);
	}

	public boolean deleteGoodType(GoodType goodType) {		
		if (!list.contains(goodType)) {
			return false;
		}
		list.remove(goodType);
		return true;
	}

	public String create(String name, GoodType type) {
		GoodType newType = new GoodType();
		newType.setName(name);
		newType.setParent(type);
		newType.setId(generateID(newType));
		list.add(newType);
		return "Successfully created.";
	}

	private Integer generateID(GoodType newType) {
		return newType.hashCode();
	}

	public GoodType read(Integer typeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
