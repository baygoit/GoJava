package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;

public class StubGoodDao extends StubGenericDao<Good>{
	protected Integer getId(Good object){
		return object.getId();
	}

	protected Good setId(Integer id, Good object){
		object.setId(id);
		return object;
	}

	protected Integer generateId(Good object){
		return object.getId();
	}	
}

