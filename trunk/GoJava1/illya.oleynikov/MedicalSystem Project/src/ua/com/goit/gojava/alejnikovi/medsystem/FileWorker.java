package ua.com.goit.gojava.alejnikovi.medsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FileWorker {
	
	private static final String PATH = "C:\\workspace\\MedicalSystem Project\\";

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
		createNewFile(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + fileName, true));
		bw.write(value);
		bw.write('\n');
		bw.close();
	}
	
	static void writeToFile(String fileName, Collection<Persistable> list) throws IOException {
		for(Persistable iterator:list){
			writeToFile(fileName, iterator.markupForFile());
		}
	}

	private static void createNewFile(String fileName) throws IOException {
		File file = new File(PATH + fileName);
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	static void updateFile (String fileName, Collection<Persistable> list) throws IOException{
		clearFile(fileName);
		writeToFile(fileName, list);
	}

	static void clearFile(String fileName) throws IOException {
		File file = new File(PATH + fileName);
		file.delete();
		file.createNewFile();
	}

}
