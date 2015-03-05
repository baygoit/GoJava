package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.model.util.Attribute;
import ua.com.goit.gojava.andriidnikitin.service.IDAO;

public class GoodDao implements GenericDao<Good> {
	
	List<Good> list;
	
	public GoodDao() {
		list = new ArrayList<Good>();
		try {
			init();
		} catch (MyShopDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Good read(int key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Good arg) {
		for (Good good: list) {
			if (good.getId().equals(arg.getId())) {
				list.remove(good);
				list.add(arg);
				return;
			}
		}
		create(arg);
	}
	
	public Good read(Integer goodId){
		Good result = null;
		for (Good good: getAll()) {
			Integer id= good.getId();
			if (id.equals(goodId)){
				result = good;
			}
		}
		return result;
	}


	@Override
	public List<Good> getAll() {
		List<Good> result = new ArrayList<Good>(list);
		return result;
	}
	
	private void init() throws MyShopDAOException {
		
			PostgresqlGoodTypeDao dao = PostgresqlGoodTypeDao.getInstance();
			GoodType type = dao.getAll().get(4);
			System.out.println(type.getName());
			List<Attribute> description = new ArrayList<Attribute>();
			
			Good good = new Good();
			good.setId(1);
			good.setName("Fender Strat");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
			
			good = new Good();
			good.setId(2);
			good.setName("Fender Telecaster");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
			
			
			good = new Good();
			good.setId(3);
			good.setName("Gibson Les Paul");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
			
			type = dao.getAll().get(1);
			
			good = new Good();
			good.setId(4);
			good.setName("Fender Rhodes");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
			
			good = new Good();
			good.setId(5);
			good.setName("Korg MS-20");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
			
			type = dao.getAll().get(2);
			
			good = new Good();
			good.setId(6);
			good.setName("Boss Delay");		
			good.setType(type);
			good.setDescription(description);
			list.add(good);
	}
	
	private int generateID(Good good){
		return good.hashCode();
	}
	
	
	
	public String create(String name, GoodType type) {
		Good newGood = new Good();
		newGood.setName(name);
		newGood.setType(type);
		newGood.setId(generateID(newGood));
		create(newGood);
		return "Successfully created.";
	}
	
	@Override
	public Good create(Good arg) {
		list.add(arg);	
		return arg;
	}
	
	
	@Override
	public void delete(Good record) {
		if (list.contains(record)){
			list.remove(record);	
		}	
	}
}
