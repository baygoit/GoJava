import java.io.File;
import java.io.IOException;


public class Story {

	public static void addToStory(String message) throws IOException {
		WriteToFile.writeToFile(new File("Story.properties"), message);
	}

}
