package com.go_java4.alex_mirn.data_containers;

import java.io.IOException;
import java.util.Random;

public abstract class Repository {
		public static QuotesContainer quotes;
		public static CategoriesContainer categories = new CategoriesContainer();
		public static ProjectsContainer projects = new ProjectsContainer();
		
		public Repository(Random random) throws IOException {
			Repository.quotes = new QuotesContainer(random);
			getData();
		}
		
		public void getData() throws IOException {
		}
	
}
