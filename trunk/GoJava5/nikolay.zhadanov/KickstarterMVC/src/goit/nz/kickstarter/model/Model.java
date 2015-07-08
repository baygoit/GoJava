package goit.nz.kickstarter.model;

import java.util.Map;

public abstract class Model {
	private String modelType;
	private String name;

	public Model(String type, String name) {
		modelType = type;
		this.name = name;
	}

	public String getType() {
		return modelType;
	}
	
	public String getName() {
		return name;
	}

	abstract public int size();
	
	abstract public Map<Integer, Map<String, String>> getData();
}
