package mainkick;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReaderBD {
	
	public HashMap<Integer, String> read(String fileName, String counter) throws FileNotFoundException {
	    exists(fileName);
	    Map<Integer, String> hashmap = new HashMap<Integer, String>();
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        try {
	            String line;
	            Integer i = 0;
	            while ((line = in.readLine()) != null) {
	            	hashmap.put(i, line);
	            	i++;
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		return (HashMap<Integer, String>) hashmap;
	}
	
	private void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	
}
