package com.go_java4.alex_mirn.data_containers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;

public class FileRepository extends Repository {
	private static String PATH = "src/com/go_java4/alex_mirn/data_containers/data/";
	
	public FileRepository() throws IOException {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
		getData();
}

	public void getData() throws IOException {
		getQuotes();
		getCategories();
		getProjects();
	}

	private void getQuotes() throws IOException {
		List<String> lineList = readfile("quotes.txt");
		addQuotes(lineList);
	}

	private void addQuotes(List<String> lineList) {
		for (String line: lineList) {
			List<String> list = new ArrayList<String>(Arrays.asList(line.split(",")));
			quotes.add(new Quote(Integer.parseInt(list.get(0)), list.get(1)));
		}
	}

	private List<String> readfile(String filename) throws IOException {
		List<String> lineList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(PATH + filename));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	        	lineList.add(line);
	            line = br.readLine();
	        }
	    } finally {
	        br.close();
	    }
	    return lineList;
	}

	private void getProjects() {
		Project alcoTester = new Project(1, categories.get(0), "Alco Tester",
				"Phenomenal alco test just by scanning your eyes", 50000,
				23000, 15);
		alcoTester.setHistory("Far-far away...");
		alcoTester.setVideoLink("verbohlest.narod.ru");
		alcoTester.setQuestions("what?");
		Project eyes = new Project(2, categories.get(0), "Eyes training device",
				"Get 100% sight", 100000, 15000, 24);
		Project melody = new Project(3, categories.get(1), "Sing Melody",
				"Sing melody and hear how it sounds in "
						+ "different musical instruments", 15000, 22000, 110);
		projects.add(alcoTester);
		projects.add(eyes);
		projects.add(melody);
	}
	
	private void getCategories() throws IOException {
		List<String> lineList = readfile("categories.txt");
		addCategories(lineList);
	}

	private void addCategories(List<String> lineList) {
		for (String line: lineList) {
			List<String> list = new ArrayList<String>(Arrays.asList(line.split(",")));
			categories.add(new Category(Integer.parseInt(list.get(0)), list.get(1)));
		}
	}
}
