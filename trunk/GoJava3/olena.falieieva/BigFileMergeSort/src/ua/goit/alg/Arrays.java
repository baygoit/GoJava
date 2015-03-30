package ua.goit.alg;

import java.io.*;
import java.util.*;


public class Arrays {

	public static File mergeSort(File file, int blocksize) throws IOException {

		ArrayList<File> partList = splitSort(file, blocksize);
		File result = mergeParts(partList).get(0);
		return result;
	}

	public static ArrayList<File> mergeParts(ArrayList<File> partList) throws IOException {
		//TODO: Incorrect merge with multiple redundancies.
		if (partList.size()>1) {
			ArrayList<File> resultList = new ArrayList<File>();
			if (partList.size() % 2 == 1) {
				partList.add(mergeFiles(partList.get(0), partList.get(1)));
				Main.printFile(mergeFiles(partList.get(0), partList.get(1)));
				partList.remove(0);
				partList.remove(1);
			}	

			for (int i=0; i<partList.size(); i++){
				resultList.add(mergeFiles(partList.get(i), partList.get(i+1)));
				i++;

			}

			return resultList = mergeParts(resultList);
		} else {
			return partList;
		}
	}

	public static ArrayList<File> splitSort(File file, int blocksize) throws IOException {
		int tmpint = 0;
		Scanner sc = null;
		ArrayList<File> filelist = new ArrayList<File>();

		sc = new Scanner(file);

		while(sc.hasNextInt()){ 
			//System.out.println("[");
			int[] array = new int[blocksize]; 
			for (int i=0; i<blocksize; i++) {
				try {
					tmpint = sc.nextInt();
				} catch (NoSuchElementException e) {
					break;
				}						
				array[i] = tmpint;
				//System.out.println(array[i]);
			}

			//System.out.println("]");
			array=sortArray(array);
			filelist.add(writeToTempFile(array));
		} 
		sc.close();
		return filelist; 
	}  

	private static File writeToTempFile(int[] array) throws IOException {

		DataOutputStream fdo = null;
		File newtmpfile = File.createTempFile("toFile", "temp", new File("G://Java/Temp/"));
		newtmpfile.deleteOnExit(); //delete when JVM stops
		try {
			fdo = new DataOutputStream(new FileOutputStream(newtmpfile));
			for(int i=0; i<array.length; i++) {
				fdo.writeInt(array[i]);
			}
		} catch (NoSuchElementException e){
			e.printStackTrace();
		} finally {
			fdo.close();
		}
		return newtmpfile;
	}
	public static int readIntFromFile(File file, long pointer) throws IOException{

		RandomAccessFile run = new RandomAccessFile(file,"rw");
		run.seek(pointer);
		int i = run.readInt();
		run.close();
		return i;
	}

	public static void writeIntToFile(File file, int i, long pointer) throws IOException{

		RandomAccessFile run = new RandomAccessFile(file,"rw");
		run.seek(pointer);
		run.writeInt(i);
		run.close();
	}

	public static File mergeFiles(File firstFile, File secondFile) throws IOException {

		int fInt;//Value of firstFile elements
		int sInt;//Value of secondFile elements
		long fpos = 0;//Indexes of firstFile elements
		long spos = 0;//Indexes of secondFile elements
		long wpos = 0;//Position in written file
		boolean EOF = false;//End of the firstFile flag
		//boolean EOSF = false;//End of the secondFile flag

		File file = File.createTempFile("TMPFile", "merge", new File("G://Java/Temp"));
		//file.deleteOnExit(); 
		try {

			fInt = readIntFromFile(firstFile, fpos);
			sInt = readIntFromFile(secondFile, spos);
			while (!EOF){

				if (fInt < sInt) {

					writeIntToFile(file, fInt, wpos);
					fpos=byteInc(fpos); //Convert byte to int
					//System.out.println(fInt+" < "+sInt);
					wpos=byteInc(wpos);
					fInt = readIntFromFile(firstFile, fpos);

				} else if (fInt > sInt){

					writeIntToFile(file, sInt, wpos);
					spos=byteInc(spos); 
					//System.out.println(fInt+" = "+sInt);
					wpos=byteInc(wpos);
					sInt = readIntFromFile(secondFile, spos);

				} else {

					writeIntToFile(file, sInt, wpos);
					spos=byteInc(spos);
					wpos=byteInc(wpos);
					writeIntToFile(file, fInt, wpos);
					fpos=byteInc(fpos); //Convert byte to int
					wpos=byteInc(wpos);
					fInt = readIntFromFile(firstFile, fpos);
					sInt = readIntFromFile(secondFile, spos);
				}
			}
		} catch (EOFException e){

			while (spos < secondFile.length()) {
				writeIntToFile(file, readIntFromFile(secondFile, spos),  wpos);
				spos=byteInc(spos); 
				wpos=byteInc(wpos);
			}
			while (fpos < firstFile.length()) {
				writeIntToFile(file, readIntFromFile(firstFile, fpos), wpos);
				fpos=byteInc(fpos); 
				wpos=byteInc(wpos);
			}

			EOF=true;

		}

		return file;
	}

	private static long byteInc(long pos){
		return pos+4;
	}

	private static int[] sortArray(int[] array) { //bubbleSortIncrease
		for(int i = array.length-1 ; i > 0 ; i--){
			for(int j = 0 ; j < i ; j++){
				if( array[j] > array[j+1] ){
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		return array;
	}
}

