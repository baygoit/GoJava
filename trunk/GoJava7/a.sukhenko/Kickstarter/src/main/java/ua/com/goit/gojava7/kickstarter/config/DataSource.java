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
}
