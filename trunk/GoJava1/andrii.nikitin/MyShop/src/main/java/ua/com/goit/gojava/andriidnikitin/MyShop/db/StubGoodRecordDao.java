package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;

public class StubGoodRecordDao extends StubGenericDao<GoodRecord>{
	protected Integer getId(GoodRecord object){
		return object.getId();
	}

	protected GoodRecord setId(Integer id, GoodRecord object){
		object.setId(id);
		return object;
	}

	protected Integer generateId(GoodRecord object){
		return object.getId();
	}	
}

