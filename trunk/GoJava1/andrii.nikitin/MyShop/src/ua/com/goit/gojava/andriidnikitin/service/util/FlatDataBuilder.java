package ua.com.goit.gojava.andriidnikitin.service.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FlatDataBuilder {
	
	private final String filepath;
	
	public FlatDataBuilder(String filepath){
		this.filepath = filepath;
	}


	public List<String> getCSVElements(String string) {
		List<String> list = new ArrayList<String>();
		if (string == null) {
			return null;
		}
		String[] array = string.split(",");
		for (String word: array){
			list.add(word);
		}
		return list;
	}
	
	public String makeCSVElement(String[] elements) {
		StringBuilder result = new StringBuilder();
		for (String element: elements) {
			result.append(element).append(',');
		}
		return result.toString();
	}
	
	public synchronized void write(String text) {
		FileWorker.write(filepath, text);
	}
	
	public synchronized String read() throws FileNotFoundException {
	   return FileWorker.read(filepath);
	}
	
	public synchronized void append(String newText) throws FileNotFoundException {
		FileWorker.update(filepath, newText);
	}
	
	public synchronized void delete() throws FileNotFoundException {
	    FileWorker.delete(filepath);
	}
	
}
