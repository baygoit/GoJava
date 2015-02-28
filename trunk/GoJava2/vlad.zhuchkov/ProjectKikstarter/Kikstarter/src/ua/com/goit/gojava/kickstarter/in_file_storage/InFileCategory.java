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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class InFileCategory implements Category, Serializable {
	private String name;
	private File fileProjects = new File(name + " projects");
	private Set<File> projects = new LinkedHashSet<>();
	private transient PrintWriter fileWriter;
	private transient BufferedReader readFile;

	public InFileCategory(String name) {
		this.name = name;
		try {
			fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
					fileProjects)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addProject(Project project) {
		fileWriter.println(project.getName());
		File file = new File(project.getName());
		projects.add(file);
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(project);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<String> getProjectCatalog() {
		try {
			readFile = new BufferedReader(new FileReader(fileProjects));
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
	public Project getProject(int index) {
		if (index >= size())
			throw new IlligalInputException();
		File[] array = projects.toArray(new File[projects.size()]);
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
		Project project = null;
		try {
			project = (Project) is.readObject();
			is.close();
			return project;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;

	}

	@Override
	public int size() {

		return projects.size();
	}

}