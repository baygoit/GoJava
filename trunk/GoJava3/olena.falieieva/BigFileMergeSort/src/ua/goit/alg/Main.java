package ua.goit.alg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	String property = "java.io.tmpdir";
	String tempDir = System.getProperty(property);
	File origfile = File.createTempFile( "result", ".txt", new File(tempDir));
	FileWriter fw = new FileWriter(origfile);
	int blocksize;
	//Testcases
	blocksize = 7;
	//blocksize = 6;
	//blocksize = 9;
	//String cq1 = "0 9 9 9 1 3 5 7 2 3 5 8 1 8 5 3 1 8 4 5 7";
	String cq1 = "88 55 22 33 66 52 42 47 28 38 98 705 1112 3 11 70 18";
	
	fw.append(cq1);
	fw.flush();
	fw.close();

	File result = new File("tempDir/RESULT.txt");

	result = Arrays.mergeSort(origfile, blocksize);
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





