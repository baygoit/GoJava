package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Kikstarter {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int selectCategorie;
		Scanner input = new Scanner(System.in);
		Quote quote = new Quote();
		Project project = new Project();

		// show quote random
		System.out.println(quote.getQuote());
		System.out.println("====================");

		// create object class Category for display list categories
		Categorie categorie = new Categorie();
		for (int i = 0; i < categorie.listCategoies.size(); i++) {
			System.out.println(i + " : " + categorie.listCategoies.get(i));
		}

		System.out.println("====================");

		// offer the customer to select a category from the list
		System.out.println("Select number categorie from list");
		selectCategorie = Integer.parseInt(input.nextLine());
		System.out.println("You selected categorie - "
				+ categorie.getCategoie(selectCategorie));

		if (selectCategorie >= 0) {
			System.out.println("Selected category contain projects: "
					+ project.listPoject.get(selectCategorie));
		}
	}

}
