package ua.com.goit.gojava7.kickstarter.dao;

public enum MyDataSource {

	MEMORY("m"), FILE("f"), DB("d");

	private final String startupKey;

	MyDataSource(String startupKey) {
		this.startupKey = startupKey;
	}

	public String getStartupKey() {
		return startupKey;
	}

	public static MyDataSource getByStartupKey(String startupKey) {
		for (MyDataSource element : MyDataSource.values()) {
			if (element.getStartupKey().equals(startupKey)) {
				return element;
			}
		}
		return MEMORY;
	}
	
	public static MyDataSource getByKey(String key) {
		for (MyDataSource element : MyDataSource.values()) {
			if (element.toString().equals(key)) {
				return element;
			}
		}
		return MEMORY;
	}

}
