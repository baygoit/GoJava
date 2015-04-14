package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.CustomerBasket;

public class HibernateCustomerBasketDao extends HibernateGenericExtraDao<CustomerBasket> {

	@Override
	public Class<CustomerBasket> getType(){		
		return CustomerBasket.class;
	}

	@Override
	protected String getName(CustomerBasket object) {
		return null;
	}

	

}
