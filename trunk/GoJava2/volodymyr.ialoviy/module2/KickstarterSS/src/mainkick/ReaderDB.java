package mainkick;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderDB {
	
	public ArrayList<String[]> read(String fileName){
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
	        try {
				throw new FileNotFoundException("Ми не змогли прочитать файл");
			} catch (FileNotFoundException e1) {
				// TODO
				e1.printStackTrace();
			}
	    }
		return list;
	}
	
	private void exists(String fileName){
	    File file = new File(fileName);
	    if (!file.exists()){
	        try {
				throw new FileNotFoundException(file.getName());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
}
