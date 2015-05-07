package org.dens.kikstarter.face;

import java.io.PrintStream;
import java.util.Scanner;

import org.dens.kikstarter.data.Category;
import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;

public class ConsoleKikstarter {

	PrintStream out = System.out;
	Scanner in = new Scanner(System.in);
	
	CitationProducer citationProducer;
	CategoryProducer categoryProducer;
    
	public void setCitations(CitationProducer citationProducer) {
		this.citationProducer = citationProducer;
	}	

	public void start(){
		out.println("Citate of the day: "+ citationProducer.next());	
		printCategories();	
		proposeUserToSelectCategory();
	}

	private void proposeUserToSelectCategory() {
		out.print("Choose Category: ");
		String input = in.nextLine();
		try{
			int option = parseInput(input);
			Category category = categoryProducer.getCategories().get(option);
			out.println( category.getName());
			out.println( category.getDescription());
		}catch(Exception ex){
			out.println("Incorrect input: " + input);
		}		
	}

	private int parseInput(String input) {
		return Integer.valueOf(input);		
	}

	private void printCategories() {
		out.println("Categories:");
		for(int index = 0; index < categoryProducer.getCategories().size(); index++){
			out.println(" "+index + " - "+ categoryProducer.getCategories().get(index));
		}		
	}

	public void setCategoies(CategoryProducer categoryProducer) {
		this.categoryProducer = categoryProducer;		
	}
}
