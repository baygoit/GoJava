package ua.kutsenko.KickstarterGoIt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quotes implements Writer {
	
	private List <String> allQuotes = new ArrayList<String>();
	private String quotesFileName = "./resources/quotes.txt";
	
	public void printQuote() {
		write("Select data: 1 memory , 2 file");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		if(select == 1 ){
			initMemoryQuotes();
			int index = new Random().nextInt(allQuotes.size());
			write(allQuotes.get(index));
		}if (select == 2){
			initFileQuotes();
			int index = new Random().nextInt(allQuotes.size());
			write(allQuotes.get(index));
		}
				
	}

	private void initFileQuotes() {
		try (BufferedReader is = new BufferedReader(new FileReader(quotesFileName))) {
			String quote1 = is.readLine();
			String quote2 = is.readLine();
			allQuotes.add(quote1);
			allQuotes.add(quote2);
			} catch (IOException e) {
			throw new IllegalStateException("Cannot read quotes from file");
		}
		
	}

	private void initMemoryQuotes(){
		allQuotes.add("Клевета как уголь: не обожжет, так замарает.");
		allQuotes.add("Помирать собрался, а жито сей.");
		allQuotes.add("Утро вечера мудренее.");
		allQuotes.add("Плох тот солдат, который не думает быть генералом.");
		allQuotes.add("У Фили пили, да Филю ж и били.");
	}
	



	public void write(String string) {
		
		System.out.println(string);
		
	}



}
