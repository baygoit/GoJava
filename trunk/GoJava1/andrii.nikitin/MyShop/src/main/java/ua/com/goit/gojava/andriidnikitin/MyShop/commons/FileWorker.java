package ua.com.goit.gojava.andriidnikitin.MyShop.commons;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


public class FileWorker {

	public static void write(String fileName, String text) {
		try {
	    File file = new File(fileName);
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            out.print(text);
	        } finally {
	            out.close();
	        }
		}   catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static List<String> read(String fileName) throws FileNotFoundException {
		List<String> result = new LinkedList<String>();
	    exists(fileName);
	    File file = new File(fileName);
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	        try {
	            String string;
	            while ((string = in.readLine()) != null) {
	                result.add(string);
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	    return result;
	}
	
		public static void update(String nameFile, String newText) throws FileNotFoundException {
	    exists(nameFile);
	    StringBuilder sb = new StringBuilder();
	    List<String> oldFile = read(nameFile);
	    sb.append(oldFile);
	    sb.append(newText);
		write(nameFile, sb.toString());
	}
	
	public static void delete(String nameFile) throws FileNotFoundException {
	    exists(nameFile);
	    new File(nameFile).delete();
	}
	
	private static void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	

}	
	