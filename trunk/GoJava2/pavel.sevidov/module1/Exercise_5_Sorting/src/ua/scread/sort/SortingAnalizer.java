package ua.scread.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ua.scread.generator.GeneratorAlgorithm;

/**
 * Perform statistical calculations of sorting speed.
 * @author ScreaD
 *
 */
public class SortingAnalizer extends Sorter {
	//size of test array
	final int MAX_COEF = 10_000;
	//array's generators
	private ArrayList<GeneratorAlgorithm> generators;
	//array's sorters
	private ArrayList<SortingAlgorithm> sorters;
	
	public SortingAnalizer(){
		generators = new ArrayList<GeneratorAlgorithm>();
		sorters = new ArrayList<SortingAlgorithm>();
		ArrayList<String> generatorsName = getAllGeneratorAlgorithms();
		ArrayList<String> sortersName = getAllSorterAlgorithms();
		//find all generators in corresponding package
		System.out.println("\tList of GeneratorAlgorithms, which are used:\n" + 
				generatorsName);
		//find all sorters in corresponding package
		System.out.println("\tList of SortingAlgorithms, which are used:\n" + 
				sortersName);
		//fill generators
		for(int i = 0; i < generatorsName.size(); i++){
			GeneratorAlgorithm generatorItem;
			try {
				generatorItem = (GeneratorAlgorithm) Class.forName(generatorsName.get(i)).newInstance();
				generators.add(generatorItem);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//fill sorters
		for(int j = 0; j < sortersName.size(); j++){
			SortingAlgorithm sorterItem;
			try {
				sorterItem = (SortingAlgorithm) Class.forName(sortersName.get(j)).newInstance();
				sorters.add(sorterItem);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	/**
	 * Write speed for each algorithms on different arrays to CSV file.
	 */
	public void writeStatisticsToCsvFile() {
		File csv = new File("statictics.csv");
		// create if not exists
		if (!csv.exists())
			fileCreation(csv);
		Integer[] array;
		try (FileWriter fw = new FileWriter(csv);
				BufferedWriter bw = new BufferedWriter(fw)) {
			for (int i = 0; i < generators.size(); i++) {
				// write type of array's generator
				bw.write("Array type: " + generators.get(i).toString());
				System.out.println(generators.get(i).toString());
				bw.newLine();
				for (int j = 0; j < sorters.size(); j++) {
					System.out.println("Sorter type: " + sorters.get(j).toString());
					// write type of sorting
					bw.write(sorters.get(j).toString());
					bw.newLine();
					for (int k = 1; k <= MAX_COEF; k += 100) {
						// generate array
						array = generators.get(i).generate(k);
						long start = System.nanoTime();
						sorters.get(j).sort(array);
						long end = System.nanoTime();
						array = null;
						bw.write((end - start) + ";");
						//i want start k from 1 and then increment by 100 from zero value
						//k = 1, 100, 200, 300 ...
						if(k == 1)
							k --;
					}
					bw.newLine();
					writeSizeOfArray(MAX_COEF, bw);
					bw.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\tYour statistics was writen to statistics.csv!");
	}
	private void writeSizeOfArray(int maxCoef, BufferedWriter bw){
		// write size of array
		for (int k = 1; k <= maxCoef; k += 100) {
			try {
				bw.write(k + ";");
				//i want start k from 1 and then increment by 100 from zero value
				//k = 1, 100, 200, 300 ...
				if(k == 1)
					k --;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * File creation.
	 * @param csv - file need to be created.
	 */
	private void fileCreation(File csv) {
		try {
			csv.createNewFile();
			csv.setWritable(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * check package generator and finds all array's generators.
	 * @return ArrayList with names of generator's classes.
	 */
	private ArrayList<String> getAllGeneratorAlgorithms(){
		ArrayList<String> listOfGeneratorsName = new ArrayList<String>();
		File f = new File("src" + File.separator + "generator");
		if(f.isDirectory()){
			//get all .java files from directory
			File[] listOfFiles = f.listFiles();
			for(File file: listOfFiles){
				String className = "generator." + 
						file.getName().substring(0, file.getName().length() - 5);
				try {
					//get all interfaces of class
					Class<?>[] interfacesOfClass = Class.forName(className).getInterfaces();
					for(Class<?> cl: interfacesOfClass){
						//if class implements GeneratorAlgorithm
						if(cl.equals(GeneratorAlgorithm.class))
							listOfGeneratorsName.add(className);
					}
				} catch(Exception e) {
					System.out.println("Casting error! " + className + " "
							+ "isn't concrete class for array generation!");
				}
			}
		}
		return listOfGeneratorsName;
	}
	/**
	 * check package sorter and finds all array's sorters.
	 * @return
	 */
	private ArrayList<String> getAllSorterAlgorithms(){
		ArrayList<String> listOfSortersName = new ArrayList<String>();
		File f = new File("src" + File.separator + "sort");
		if(f.isDirectory()){
			//get all .java files from directory
			File[] listOfFiles = f.listFiles();
			for(File file: listOfFiles){
				String className = "sort." + 
						file.getName().substring(0, file.getName().length() - 5);
				try {
					//get superClass and check if current class is a sub class of SortingAlgorithm
					Class<?> superClass = Class.forName(className).getSuperclass();
					if(superClass.equals(SortingAlgorithm.class))
						listOfSortersName.add(className);
				} catch(Exception e){
					System.out.println("Casting error! " + className + " "
							+ "isn't concrete class for array sorting!");
				}
			}
		}
		return listOfSortersName;
	}
}