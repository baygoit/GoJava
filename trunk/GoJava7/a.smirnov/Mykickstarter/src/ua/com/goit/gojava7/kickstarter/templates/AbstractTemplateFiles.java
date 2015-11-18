//package ua.com.goit.gojava7.kickstarter.templates;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//
//public abstract class AbstractTemplateFiles<T> implements Templateble<T> {
//	private static final String PROBLEMS = "Ooops...something wrongs";
//	private File file;
//
//	public AbstractTemplateFiles() {
//		file = new File("d://gojava7/" + getClass().getName() + ".txt");
//		
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				System.out.println(PROBLEMS);
//			}
//		}
//	}
//
//	public void add(T element) {
//		Set<T> sourceStorage = getSetFromFile();
//		sourceStorage.add(element);
//		writeSetToFile(sourceStorage);
//	}
//
//	public void remove(T element) {
//		Set<T> sourceStorage = getSetFromFile();	
//		sourceStorage.remove(element);
//		writeSetToFile(sourceStorage);
//	}
//
//	public Set<T> getAll() {
//		return getSetFromFile();
//	}
//
//	public List<T> convertSetInList(Set<T> sourceStorage) {
//		List<T> listOfSources = new ArrayList<>();
//		
//		Iterator<T> quotesIterator = sourceStorage.iterator();
//		
//		while (quotesIterator.hasNext()) {
//			listOfSources.add(quotesIterator.next());
//		}
//		
//		return listOfSources;
//	}
//	
//	public Set<T> getSetFromFile() {
//		Set<T> sourceStorage = new TreeSet<>();
//		
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//			sourceStorage = (TreeSet<T>) in.readObject();
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println(PROBLEMS);
//		}
//		
//		return sourceStorage;
//	}
//	
//	public void writeSetToFile(Set<T> sourceStorage) {
//		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
//			out.writeObject(sourceStorage);
//			out.flush();
//		} catch (IOException e) {
//			System.out.println(PROBLEMS);
//		}
//	}
//}
