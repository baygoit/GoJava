package ua.com.goit.gojava.andriidnikitin.service.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class FileWorker {

	public static void write(String fileName, String text) {
	    File file = new File(fileName);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            out.print(text);
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static String read(String fileName) throws FileNotFoundException {
	    StringBuilder sb = new StringBuilder();
	    exists(fileName);
	    File file = new File(fileName);
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	        try {
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	    return sb.toString();
	}
	
		public static void update(String nameFile, String newText) throws FileNotFoundException {
	    exists(nameFile);
	    StringBuilder sb = new StringBuilder();
	    String oldFile = read(nameFile);
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
	