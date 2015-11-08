package com.ivanpozharskyi.kickstarter.entity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReaderFromFile {
	private BufferedReader reader;

	private String fileName;
	private List<String> lines;
	ReaderFromFile(String fileName){
		this.fileName = fileName;
	}
	public List<String> read() throws IOException{
		reader = new BufferedReader(new FileReader(fileName));
		String line; 
		lines = new ArrayList<String>();
		while((line = reader.readLine())!= null){
			lines.add(line);
		}
		return lines;
	}
	
}
