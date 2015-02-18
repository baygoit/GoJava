package ua.com.goit.gojava2.solo307.interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IO {
	
	public static void writeToFile(String name, String time, List<String> results,
			List<String> incorrectAnswers){
		File file = new File(name);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.getMessage();
			}
		}
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name, true))); 
			out.println("Name: " + name);
			out.println("Time: " + time);
			for(String line: results){
				out.println(line);
			}
			for(String line: incorrectAnswers){
				out.println(line);
			}
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> readFile(String name){
		List<String> readLines = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(name));
			String sCurrentLine;
			while ((sCurrentLine = reader.readLine()) != null) {
				readLines.add(sCurrentLine);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLines;
	}

}
