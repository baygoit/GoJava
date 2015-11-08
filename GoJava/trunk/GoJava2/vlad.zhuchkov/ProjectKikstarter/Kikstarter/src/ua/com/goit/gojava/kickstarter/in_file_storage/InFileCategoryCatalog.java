package ua.com.goit.gojava.kickstarter.in_file_storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;

public class InFileCategoryCatalog implements CategoryCatalog {
	int size;
	private File fileCatalog = new File("Catalog.txt");
	private Set<File> catalog = new LinkedHashSet<>();
	private PrintWriter fileWriter;
	private BufferedReader readFile;

	public InFileCategoryCatalog() {
		fileCatalog.delete();
	}

	@Override
	public void addCategory(String name) {
		if (!catalog.contains(new File(name))) {
			try {
				fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
						fileCatalog, true)));
				fileWriter.println(name);
				fileWriter.close();
				size++;
				File file = new File(name);
				ObjectOutputStream os = new ObjectOutputStream(
						new FileOutputStream(file));
				os.writeObject(new InFileCategory(name));
				catalog.add(file);
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<String> getCatalog() {
		try {
			readFile = new BufferedReader(new FileReader(fileCatalog));
			try {
				List<String> list = new ArrayList<>();
				String tmpRead = readFile.readLine();
				while (tmpRead != null) {
					list.add(tmpRead);
					tmpRead = readFile.readLine();
				}
				return list;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				readFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category getCategory(int index) {
		File[] array = catalog.toArray(new File[catalog.size()]);
		File file = array[index];
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category category = null;
		try {
			category = (Category) is.readObject();
			is.close();
			return category;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public int size() {
		return size;
	}

}
