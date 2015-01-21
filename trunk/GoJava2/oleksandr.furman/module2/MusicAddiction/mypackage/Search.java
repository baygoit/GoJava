package mypackage;

import java.util.Random;
import java.util.Scanner;


public class Search {
	String trackName = "";
	protected String searchByKeywords() {
		System.out.println("Enter a keyword to search:");
		Scanner scanner = new Scanner(System.in);
		String keywordToSearch = scanner.nextLine();
		trackName = keywordToSearch;
		Random ran = new Random();
		int randomNum = ran.nextInt(187);
		System.out.println("By Keyword " + keywordToSearch + " found "+ randomNum + " results.");
		return keywordToSearch;		
	}
}
