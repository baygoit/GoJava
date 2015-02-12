package ua.com.goit.gojava.andriidnikitin.model.DAO;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class GoodTypeDAO implements IDAO<GoodType> {
	
	List<GoodType> list;

	@Override
	public void create(GoodType arg) {
		
		list.add(arg);

	}

	@Override
	public void update(GoodType arg) {

		for (GoodType type: list) {
			if (type.getId().equals(arg.getId())) {
				list.remove(type);
				list.add(arg);
				return;
			}
		}
		create(arg);
		
	}

	@Override
	public List<GoodType> getAll() {

		List<GoodType> result = new ArrayList<GoodType>(list);
		return result;
		
	}

}
