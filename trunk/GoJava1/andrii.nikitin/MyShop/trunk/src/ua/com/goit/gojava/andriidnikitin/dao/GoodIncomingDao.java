package ua.com.goit.gojava.andriidnikitin.dao;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.service.IDAO;

public class GoodIncomingDao implements IDAO<GoodIncoming> {
	
	List<GoodIncoming> list;

	@Override
	public boolean create(GoodIncoming arg) {
		return list.add(arg);
		
	}

	@Override
	public void update(GoodIncoming arg) {
		for (GoodIncoming good: list) {
			if (good.getId().equals(arg.getId())) {
				list.remove(good);
				list.add(arg);
				return;
			}
		}
		create(arg);
	}

	@Override
	public List<GoodIncoming> getAll() {
		List<GoodIncoming> result = new ArrayList<GoodIncoming>(list);
		return result;
	}

}
