package ua.goit.alg;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		File origfile = new File("G://Java/TEST.txt");
		File result = new File("G://Java/RESULT.txt");

		File file = File.createTempFile("TMPFile", "merge", new File("G://Java/Temp"));
		result = Arrays.mergeSort(origfile, 8);

		Arrays.writeIntToFile(file, 9, 0);
		ArrayList<File> split = Arrays.splitSort(origfile, 8);
		File merge = Arrays.mergeFiles(split.get(0), split.get(1));
	}

	public static void printFiles(ArrayList<File> split) throws IOException{
		for(File part : split) {
			printFile(part);
		}
	}
	public static void printFile(File part) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream fin = new DataInputStream(new FileInputStream(part));
		String name;
		boolean eof = false;
		System.out.println("Print File "+part.getName()+"? y/n");
		name = br.readLine();
		if(name.equals("y"))
			try{
				while (!eof) {
					System.out.println((fin.readInt()));
				} 
			} catch (EOFException e){
				eof = true;
			}
		fin.close();
	}


}





