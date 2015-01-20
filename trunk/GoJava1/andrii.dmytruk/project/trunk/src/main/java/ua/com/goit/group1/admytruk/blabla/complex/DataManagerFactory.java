package ua.com.goit.group1.admytruk.blabla.complex;

public class DataManagerFactory {

	public static final String PROPERTY_NAME = "dataManagerType";
			
	public static DataManager createDataManager() {
		DataManagerAbstract instance =  build();
		instance.init();
		return instance;
	}

	// TODO: текущую реализацию нужно отрефакторить
	// да и вся реализация не показательная. 
	private static DataManagerAbstract build() {
		final String type = System.getProperty(PROPERTY_NAME);
		if (type == null) {
			throw new IllegalArgumentException("Please set " + PROPERTY_NAME + " env to configure factory");
		}
		if ("inMemory".equals(type)) {
			return new DataManagerInMemory();
		} else if ("xml".equals(type)) {
			return new DataManagerXML();
		}
		return null;
	}
}
