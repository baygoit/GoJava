package com.go_java4.alex_mirn.data_containers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;

public class TestRepository extends Repository{

		public TestRepository() throws IOException {
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

	private void getProjects() {
		Project alcoTester = new Project(categories.get(0), "Alco Tester",
				"Phenomenal alco test just by scanning your eyes", 50000,
				23000, 15);
		alcoTester.setHistory("Far-far away...");
		alcoTester.setVideoLink("verbohlest.narod.ru");
		alcoTester.setQuestions("what?");
		Project eyes = new Project(categories.get(0), "Eyes training device",
				"Get 100% sight", 100000, 15000, 24);
		Project melody = new Project(categories.get(1), "Sing Melody",
				"Sing melody and hear how it sounds in "
						+ "different musical instruments", 15000, 22000, 110);
		projects.add(alcoTester);
		projects.add(eyes);
		projects.add(melody);
	}

	private void getCategories() {
		Category medicine = new Category("Medicine");
		Category music = new Category("Music");
		
		categories.add(medicine);
		categories.add(music);
	}

	private void getQuotes() {
		quotes.add(new Quote("Impossible is nothing"));
		quotes.add(new Quote("Smile makes you better"));
		quotes.add(new Quote("Just do it!!!"));
	}

}