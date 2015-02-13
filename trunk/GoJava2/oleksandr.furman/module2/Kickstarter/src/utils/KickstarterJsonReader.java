package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class KickstarterJsonReader<T> {
	private List<T> list;

	private void jsonProjectsToList(Class<T> type, String filePath) {
		Gson gson = new Gson();
		list = new ArrayList<T>();
		for (JsonElement obj : readJsonFromHardDrive(filePath)) {
			T object = gson.fromJson(obj, type);
			list.add(object);
		}
	}

	private JsonArray readJsonFromHardDrive(String filePath) {
		JsonArray jArrayProjects = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			JsonParser parser = new JsonParser();
			jArrayProjects = parser.parse(br).getAsJsonArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return jArrayProjects;
	}

	public List<T> getList(Class<T> type, String filePath) {
		jsonProjectsToList(type, filePath);
		return list;
	}
}
