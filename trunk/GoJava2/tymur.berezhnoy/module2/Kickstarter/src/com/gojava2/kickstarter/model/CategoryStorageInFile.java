package com.gojava2.kickstarter.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CategoryStorageInFile implements CategoryStorage {

	private int size;
	
	private String fileURL;
	private File file;
	
	
	public CategoryStorageInFile(String fileURL) {
		this.fileURL = fileURL;
		file = new File(fileURL);
		checkFile();
	}
	
	@Override
	public int getSize() {
		readFile();
		return size;
	}

	@Override
	public void addCategory(Category category) {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader((file)));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray jArray = new JsonParser().parse(reader).getAsJsonArray();
			jArray.add(gson.toJsonTree(category));
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(gson.toJson(jArray));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
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
	public Category getCategory(int i) {
		return (Category) getCategories().toArray()[i - 1];
	}

	@Override
	public LinkedHashSet<Category> getCategories() {
		LinkedHashSet<Category> categories = new LinkedHashSet<Category>();
		Gson gson = new Gson();
		JsonArray array = readFile();
		for(JsonElement element: array) {
			categories.add(gson.fromJson(element, Category.class));
		}
		return categories;
	}
	
	private JsonArray readFile() {
		BufferedReader inPut = null;
		JsonArray jsonArr = null;
		try {
			inPut = new BufferedReader(new FileReader(file));
			jsonArr = new JsonParser().parse(inPut).getAsJsonArray();
			size = jsonArr.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(inPut != null) {
				try {
					inPut.close();
				} catch (IOException e) {
					e.printStackTrace();
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