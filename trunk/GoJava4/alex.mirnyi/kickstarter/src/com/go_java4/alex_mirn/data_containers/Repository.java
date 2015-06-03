package com.go_java4.alex_mirn.data_containers;

import java.io.IOException;


public abstract class Repository {
		public static QuotesContainer quotes = new QuotesContainer();
		public static CategoriesContainer categories = new CategoriesContainer();
		public static ProjectsContainer projects = new ProjectsContainer();
		
		public void getData() throws IOException {
		}
	
}
