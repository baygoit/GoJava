package ua.com.goit.gojava.alejnikovi.medsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileWorker {
	
	static final String PATH = "C:\\workspace\\MedicalSystem Project\\";

	public FileWorker() {
		// TODO Auto-generated constructor stub
	}
	
	static List<String> readFromFile(String fileName) throws IOException{
		String  thisLine = null;
		List<String> listFromFile = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(PATH + fileName));
        while ((thisLine = br.readLine()) != null) {
        	listFromFile.add(thisLine);
        }
        br.close();
        return listFromFile;				
	}
	
	static void writeToFile(String fileName, String value) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + fileName, true));
		bw.write('\n');
		bw.write(value);
		bw.close();
	}

}
