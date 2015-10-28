package ua.com.goit.gojava.andriidnikitin.MyShop.db;


import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;

public class HibernateGoodDao extends HibernateGenericExtraDao<Good> {

	@Override
	public Class<Good> getType() {		
		return Good.class;
	}
	

	@Override
	protected String getName(Good object) {
		return object.getName();
	}
	
}
