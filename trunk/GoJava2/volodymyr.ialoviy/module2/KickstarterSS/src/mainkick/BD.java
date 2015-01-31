package mainkick;

import java.io.IOException;
import java.util.Map;

public class BD {
	ReaderBD reader = new ReaderBD();
	
	public static Map<Integer, String[]> quoteBD;
	{
	    try {
	    	quoteBD = reader.read("Quotes.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
	
	public static Map<Integer, String[]> categoryBD;
	{
	    try {
	    	categoryBD = reader.read("Categories.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
	
	public static Map<Integer, String[]> projectBD;
	{
	    try {
	    	projectBD = reader.read("Projects.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
}
