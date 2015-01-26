package mainkick;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ReaderBD {
	
	public HashMap<Integer, String> read(String fileName, String counter) throws FileNotFoundException {
	    exists(fileName);
	    Project.counterProject = 0;
	    Category.counterCategory = 0;
	    Map<Integer, String> hashmap = new HashMap<Integer, String>();
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        try {
	            String line;
	            Integer i = 0;
	            ArrayList<String> lines = new ArrayList<String>();
	            while ((line = in.readLine()) != null) {
	            	hashmap.put(i, line);
	            	i++;
	            	lines.add(line);
	            	if (counter.equals("Project")){
		    	    	Project.counterProject++;
		    	    }
		    	    if (counter.equals("Category")){
		    	    	Category.counterCategory++;
		    	    }
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
