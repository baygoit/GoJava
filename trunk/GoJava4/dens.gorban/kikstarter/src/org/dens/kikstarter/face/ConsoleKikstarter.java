package org.dens.kikstarter.face;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.dens.kikstarter.data.Category;
import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;
import org.dens.kikstarter.data.Project;

public class ConsoleKikstarter {

	private Printer printer;
	private Reader scanner;
	private CitationProducer citationProducer;
	private CategoryProducer categoryProducer;
    
	public void start(){
		printer.printBlock("Citate of the day ",  citationProducer.next().toString());	
		printCategories();	
		Category selectedCategory = proposeUserToSelectCategory();
		proposeUserToSelectProject(selectedCategory);
	}

	private void proposeUserToSelectProject(Category selectedCategory) {
		Project[] projets = selectedCategory.getProjets();
		printer.printHeader("Projects: ");
		for(int index = 0; index< projets.length; index++){
			if(projets[index] != null){
				printer.printOption(index, projets[index].getName());
			}
		}
		String header = "Choose Project: ";
		printer.printLine(header, false);
		String input = scanner.read();
	}

	private Category proposeUserToSelectCategory() {
		String header = "Choose Category: ";
		printer.printLine(header, false);
		String input = scanner.read();
		Category category = null;
		try{
			int option = parseInput(input);
			category = categoryProducer.getCategories().get(option);
			printer.printHeader(category.getName());
			printer.printLine(category.getDescription(), false);
					
		}catch(Exception ex){
			printer.printLine("Incorrect input: " + input, false);
		}		
		return category;
	}

	private int parseInput(String input) {
		return Integer.valueOf(input);		
	}

	private void printCategories() {
		String header = "Categories:";
		List<Category> categoryList = categoryProducer.getCategories();		
		String[] categories = new String[categoryList.size()];
		for(int index = 0; index < categoryList.size(); index++){
			categories[index] = categoryList.get(index).getName();
		}
		printer.printBlock(header, categories);
	}

	public void setCategoies(CategoryProducer categoryProducer) {
		this.categoryProducer = categoryProducer;		
	}
	

	public void setCitations(CitationProducer citationProducer) {
		this.citationProducer = citationProducer;
	}	
		
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void setScanner(Reader scanner) {
		this.scanner = scanner;
	}
}

