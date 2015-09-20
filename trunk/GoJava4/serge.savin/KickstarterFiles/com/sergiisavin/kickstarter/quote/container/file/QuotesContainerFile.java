package com.sergiisavin.kickstarter.quote.container.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.quote.container.Quotes;

public class QuotesContainerFile implements Quotes {
	
	private static final String PATH = System.getProperty("user.dir"); 
	private static final String FILE_NAME = "quotes.dat";
	private static final String FILE = PATH + "\\" + FILE_NAME;
	
	public QuotesContainerFile(){}
	
	public QuotesContainerFile(String ...strings){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(FILE));
			for(String quote : strings){
				writer.write(quote + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Override
	public int getSize() {
		
		int size = 0;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(FILE));
			String line = null;
			while( (line = reader.readLine()) != null ){
				size++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return size;
	}

	@Override
	public void add(String quote) throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

	@Override
	public String getRandomQuote() {
		int size = getSize();
		int quoteIndex = new Random().nextInt(size);
		return get(quoteIndex);
	}

	@Override
	public void delete(int index) throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

	@Override
	public String get(int targetIndex) {

		if(targetIndex < 0 || targetIndex > (getSize()-1)){
			throw new Quotes.IllegalArgumentException();
		}
		
		BufferedReader reader = null;
		int fileIndex = 0;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));
			while( (line = reader.readLine()) != null){
				if(fileIndex == targetIndex){
					return line;
				}
				fileIndex++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return line;
	}

}
