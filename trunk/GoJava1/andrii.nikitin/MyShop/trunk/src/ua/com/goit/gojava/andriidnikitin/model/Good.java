package ua.com.goit.gojava.andriidnikitin.model;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.GoodDao;
import ua.com.goit.gojava.andriidnikitin.dao.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlGoodTypeDao;
import ua.com.goit.gojava.andriidnikitin.model.util.Attribute;

public class Good {
	
	private Integer id;
	
	private String name;
	
	private GoodType type;
	
	private List<Attribute> description;	

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

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}


	public List<Attribute> getDescription() {
		return description;
	}

	public void setDescription(List<Attribute> description) {
		this.description = description;
	}

	public static Good factory(Integer goodId, String nameOfGood, Integer typeId,
			Integer descriptionId) {
		Good good = new Good();
		good.setId(goodId);
		good.setName(nameOfGood);
		PostgresqlGoodTypeDao dao = PostgresqlGoodTypeDao.getInstance();
		try {
			GoodType type = dao.read(typeId);
		} catch (MyShopDAOException e) {
			good.setType(null);
		}
		// description is not implemented 
		return good ;
	}

}

