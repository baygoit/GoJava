package ua.com.goit.gojava7.kickstarter.config;

public enum DataSource {
	MEMORY("m"), MYSQL("db"), FILE("f");
	private final String startupKey;

	DataSource(String startupKey) {
		this.startupKey = startupKey;
	}

	public String getStartupKey() {
		return startupKey;
	}

	public static DataSource getByStartupKey(String startupKey) {
		for (DataSource element : DataSource.values()) {
			if (element.getStartupKey().equals(startupKey)) {
				return element;
			}
		}
		return MEMORY;
	}
	public static DataSource getDataSource(){
		String param =  System.getenv("SOURCE");
		System.out.println(System.getenv("source"));
		if(param != null){
		switch (param) {
			case "m" :
				return DataSource.MEMORY;
			case "db":
				return DataSource.MYSQL;
			case "f":
				return DataSource.FILE;
			default :
				return DataSource.MEMORY;
		}
	}
		return DataSource.MEMORY;
	}
	
	
}
