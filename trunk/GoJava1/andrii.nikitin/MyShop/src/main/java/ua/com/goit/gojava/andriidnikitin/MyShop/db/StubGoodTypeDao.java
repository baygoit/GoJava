package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class StubGoodTypeDao  extends StubGenericDao<GoodType>{
	
	public StubGoodTypeDao() {
		init();		
	}
	
	protected Integer getId(GoodType object){
		return object.getId();
	}

	protected GoodType setId(Integer id, GoodType object){
		object.setId(id);
		return object;
	}

	protected Integer generateId(GoodType object){
		return object.hashCode();
	}	
}

