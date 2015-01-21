import java.io.File;
import java.io.IOException;

public class Story {
	public void addToStory(String message) throws IOException {
		WriteToFile file = new WriteToFile();
		file.writeToFile(new File("Story.properties"), message);
	}

}
