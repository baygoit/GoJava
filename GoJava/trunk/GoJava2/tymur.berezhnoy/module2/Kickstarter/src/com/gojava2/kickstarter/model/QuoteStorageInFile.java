package com.gojava2.kickstarter.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class QuoteStorageInFile implements QuoteStorage {

	private int amountQuotes;
	private String fileURL;
	
	private File file;
	private Random random;
	
	public QuoteStorageInFile(Random random, String filePath) {
		this.random = random;
		this.fileURL = filePath;
		file = new File(fileURL);
		checkFile();
	}
	
	@Override
	public void add(Quote quote) {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader((file)));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray jArray = new JsonParser().parse(reader).getAsJsonArray();
			jArray.add(gson.toJsonTree(quote));
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(gson.toJson(jArray));
		} catch (FileNotFoundException e1) {
		} catch (IOException e2) {
		}  finally {
			if(writer != null && reader != null) {
				try {
					writer.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Quote getRandomQuote() throws IllegalArgumentException {
		Quote quote;
		Gson gson = new Gson();
		quote = gson.fromJson(readFile().get(random.nextInt(amountQuotes)), Quote.class);
		return quote;
	}
	
	private JsonArray readFile() {
		BufferedReader reader = null;
		JsonArray jsonArr = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			jsonArr = new JsonParser().parse(reader).getAsJsonArray();
			amountQuotes = jsonArr.size();
		} catch (FileNotFoundException e) {
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		return jsonArr;
	}
	
	private void checkFile() {
		BufferedWriter writer = null;
		if(!file.exists()) {
			try {
				file.createNewFile();
				
				writer = new BufferedWriter(new FileWriter(file));
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				writer.write(gson.toJson(new JsonArray()));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}