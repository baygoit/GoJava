package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;

public class HibernateGoodRecordDao extends HibernateGenericDao<GoodRecord> {

	@Override
	public Class<GoodRecord> getType(){		
		return GoodRecord.class;
	}

	@Override
	protected String getName(GoodRecord object) {
		return null;
	}

	

}
