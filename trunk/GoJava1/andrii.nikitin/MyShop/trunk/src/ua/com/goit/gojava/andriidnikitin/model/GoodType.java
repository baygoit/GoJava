package ua.com.goit.gojava.andriidnikitin.model;

import ua.com.goit.gojava.andriidnikitin.dao.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlGoodTypeDao;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodType other = (GoodType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
