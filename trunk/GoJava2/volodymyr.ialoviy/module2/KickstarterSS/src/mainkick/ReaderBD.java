package mainkick;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReaderBD {
	
	public String[] read(String fileName, String counter) throws FileNotFoundException {
	    exists(fileName);
	    String[] linesAsArray;
	    Project.counterProject = 0;
	    Category.counterCategory = 0;
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        try {
	            String line;
	            ArrayList<String> lines = new ArrayList<String>();
	            while ((line = in.readLine()) != null) {
	            	lines.add(line);
	            	if (counter.equals("Project")){
		    	    	Project.counterProject++;
		    	    }
		    	    if (counter.equals("Category")){
		    	    	Category.counterCategory++;
		    	    }
	            }
	            linesAsArray = lines.toArray(new String[lines.size()]);
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	    return linesAsArray;
	}
	
	private void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	
}
