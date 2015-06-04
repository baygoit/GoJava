package com.go_java4.alex_mirn.data_containers;


import java.io.IOException;
import java.util.Random;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;

public class TestRepository extends Repository{
	public TestRepository(Random random) throws IOException {
		super(random);
	}

	public void getData() throws IOException {
		getQuotes();
		getCategories();
		getProjects();
	}

	private void getProjects() {
		Project alcoTester = new Project(1, categories.get(0), "Alco Tester",
				"Phenomenal alco test just by scanning your eyes", 50000,
				23000, 15);
		alcoTester.setHistory("Far-far away...");
		alcoTester.setVideoLink("verbohlest.narod.ru");
		alcoTester.setQuestions("what?");
		Project eyes = new Project(2, categories.get(0), "Eyes training device",
				"Get 100% sight", 100000, 15000, 24, "231", "231", "231");
		Project melody = new Project(3, categories.get(1), "Sing Melody",
				"Sing melody and hear how it sounds in "
						+ "different musical instruments", 15000, 22000, 110);
		projects.add(alcoTester);
		projects.add(eyes);
		projects.add(melody);
	}

	private void getCategories() {
		Category medicine = new Category(1, "Medicine");
		Category music = new Category(2, "Music");
		
		categories.add(medicine);
		categories.add(music);
	}

	private void getQuotes() {
		quotes.add(new Quote(1, "Impossible is nothing"));
		quotes.add(new Quote(2, "Smile makes you better"));
		quotes.add(new Quote(3, "Just do it!!!"));
	}

}