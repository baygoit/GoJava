package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class HibernateGoodTypeDao extends HibernateGenericDao<GoodType> {

	@Override
	public Class<GoodType>getType() {
		return GoodType.class;
	}

	@Override
	protected String getName(GoodType object) {
		return object.getName();
	}	
}
