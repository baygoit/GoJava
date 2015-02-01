package mainkick;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderBD {
	
	public ArrayList<String[]> read(String fileName) throws FileNotFoundException {
	    exists(fileName);
	    ArrayList<String[]> list = new ArrayList<String[]>();
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        try {
	            String line;
	            while ((line = in.readLine()) != null) {
	            	list.add(line.split("\\[\\]"));
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		return list;
	}
	
	private void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	
}
