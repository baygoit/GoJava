package education.kickstarter.spring.ioc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StorePropertiesOfDatabase {
	void store() {
		Properties dbProperties = new Properties();
		dbProperties.put("jdbc.driverClassName", "org.postgresql.Driver");
		dbProperties.put("jdbc.url", "jdbc:postgresql://localhost:5432/kickstarter");
		dbProperties.put("jdbc.username", "postgres");
		dbProperties.put("jdbc.password", "root");
		try {
			dbProperties.store(new FileOutputStream(
					"src/main/resources/jdbc.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
