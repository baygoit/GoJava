package com.goit.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.goit.logic.Project;

public class ProjectFileReader {
	String filePath;
	ProjectFileReader(String filePath){
		this.filePath = filePath;
	}

	public Project getProject() throws IOException {
		
		Project project = new Project();
		File file = new File(filePath); // "data/test222.txt"
		BufferedReader buffereadReader = new BufferedReader(new FileReader(file));
		String line;
		int counter = 0;
		
		while ((line = buffereadReader.readLine()) != null) {
			switch(counter){
			case 0: project.setName(line);
			break;
			case 1: project.setDescription(line);
			break;
			case 2: project.setLink(line);
			break;
			case 3: project.setNeedMoney(Integer.parseInt(line));
			break;
			case 4: project.setAccumulatedMoney(Integer.parseInt(line));
			break;
			case 5: project.setFinalData(line);
			break;
			case 6: project.setCreditCardNumber(line);
			break;
			}
					counter++;
		}
		buffereadReader.close();
		return project;
	}
}
