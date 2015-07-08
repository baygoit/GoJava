package goit.nz.kickstarter.model;

import java.util.Map;

public class EmptyModel extends Model {
	
	public EmptyModel(String type, String name) {
		super(type, name);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Integer, Map<String, String>> getData() {
		// TODO Auto-generated method stub
		return null;
	}

}
