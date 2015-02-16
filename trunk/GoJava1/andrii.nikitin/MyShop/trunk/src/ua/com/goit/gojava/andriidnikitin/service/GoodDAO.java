package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;

public class GoodDAO implements IDAO<Good> {
	
	List<Good> list;

	@Override
	public void create(Good arg) {
		list.add(arg);
		
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

	@Override
	public List<Good> getAll() {
		List<Good> result = new ArrayList<Good>(list);
		return result;
	}
	
	
}
