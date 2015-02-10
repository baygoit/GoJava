package ua.com.goit.gojava.andriidnikitin;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FlatDataBuilder {
	
	private final String filepath;
	
	public FlatDataBuilder(String filepath){
		this.filepath = filepath;
	}


	public List<ArrayList<String>> getCSVElementsFromFile() throws FileNotFoundException {
		List<String> list = read();
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (list == null) {
			return null;
		}
		for (String string:list){
			ArrayList<String> sublist = new ArrayList<String>();
			String[] array = string.split(",");
			for (String word: array){
				sublist.add(word);
			}
			result.add(sublist);
		}
		return result;
	}
	
	public String makeCSVElement(String[] elements) {
		StringBuilder result = new StringBuilder();
		for (String element: elements) {
			result.append(element).append(',');
		}
		String returnString = result.toString();
		return returnString.subSequence(0, returnString.length() - 2).toString();
	}
	
	public void writeRecordsToCSV(List<String[]> list) {
		StringBuilder result = new StringBuilder();
		for (String[] array:list) {
			result.append(makeCSVElement(array));
			result.append('\n');
		}
		write(result.toString());
	}
	
	public synchronized void write(String text) {
		FileWorker.write(filepath, text);
	}
	
	public synchronized List<String> read() throws FileNotFoundException {
	   return FileWorker.read(filepath);
	}
	
	public synchronized void append(String newText) throws FileNotFoundException {
		FileWorker.update(filepath, newText);
	}
	
	public synchronized void delete() throws FileNotFoundException {
	    FileWorker.delete(filepath);
	}
	
}
