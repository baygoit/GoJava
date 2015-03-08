package com.gojava2.kickstarter.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ProjectStorageInFile implements ProjectStorage {

	private String fileURL;
	private File file;
	
	public ProjectStorageInFile(String fileURL) {
		this.fileURL = fileURL;
		file = new File(fileURL);
		checkFile();
	}
	
	@Override
	public void addProject(Project project) {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader((file)));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray jArray = new JsonParser().parse(reader).getAsJsonArray();
			jArray.add(gson.toJsonTree(project));
			
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
	public Project getProject(Category category, int i) {
		return null;
	}

	@Override
	public List<Project> getProjects(Category category) {
		List<Project> projects = new ArrayList<Project>();
		Gson gson = new Gson();
		JsonArray array = readFile();
		for(JsonElement element: array) {
				projects.add(gson.fromJson(element, Project.class));

		}
		return projects;
	}

	@Override
	public int getSize() {
		return 0;
	}
	
	private JsonArray readFile() {
		BufferedReader reader = null;
		JsonArray jsonArr = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			jsonArr = new JsonParser().parse(reader).getAsJsonArray();
			
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