package datasource;

import java.util.ArrayList;

import entities.Category;

public interface DataSource {

	ArrayList<Category> getCategoriesList();

	String getSomeQuote();

}
