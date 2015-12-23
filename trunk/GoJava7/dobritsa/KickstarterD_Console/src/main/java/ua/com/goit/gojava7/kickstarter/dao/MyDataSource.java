package ua.com.goit.gojava7.kickstarter.dao;

public enum MyDataSource {

	MEMORY, FILE, DB;
	
	public static MyDataSource getByKey(String key) {
		for (MyDataSource element : MyDataSource.values()) {
			if (element.toString().equals(key)) {
				return element;
			}
		}
		return MEMORY;
	}	
}
