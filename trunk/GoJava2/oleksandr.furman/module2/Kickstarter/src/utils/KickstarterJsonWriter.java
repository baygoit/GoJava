package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ua.home.kickstarter.content.Project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class KickstarterJsonWriter {
	public void saveJsonToHardDrive(List<Project> projectList, String savePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(projectList);
		try {
			FileWriter writer = new FileWriter(savePath);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
