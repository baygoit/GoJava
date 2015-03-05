package ua.com.goit.gojava.andriidnikitin.model;

import ua.com.goit.gojava.andriidnikitin.dao.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlGoodTypeDao;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class GoodType {
	
	private Integer id;
	private String name;
	private Integer parent;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public GoodType getParent() {
		if (this.parent == null){
			return null;
		}
		PostgresqlGoodTypeDao dao = PostgresqlGoodTypeDao.getInstance();
		GoodType parent;
		try {
			parent = dao.read(this.parent);
		} catch (MyShopDAOException e) {
			return null;
		}
		return parent;
	}
	
	public void setParent(GoodType parent) {
		if (parent == null){
			this.parent = null;
		}
		this.parent = parent.getId();
	}

	public static GoodType factory(Integer goodId, String name2,
			Integer parentId) throws MyShopDAOException {
		GoodType type = new GoodType();
		type.parent = parentId;
		type.setName(name2);
		type.setId(goodId);		
		return type;
	}
	
	
	
}
