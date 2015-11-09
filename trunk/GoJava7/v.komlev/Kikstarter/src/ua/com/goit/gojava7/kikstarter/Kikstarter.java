package ua.com.goit.gojava7.kikstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kikstarter {

	/**
	 * @throws IOException
	 * 
	 */

	public static void main(String[] args) throws IOException {
		String strResult;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		Quote quote = new Quote();
		Project project = new Project();
		Category category = new Category();

		// show quote random
		System.out.println(quote.getQuoteRandom());
		System.out.println("====================");

		// show all categories
		category.getMapCategory();

		System.out.println("====================");
		System.out.println("Selec one of the categories from list");
		strResult = reader.readLine();
		System.out.println("You selected category #" + strResult);

		project.getProject(Integer.parseInt(strResult));

	}
}
