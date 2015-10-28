import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Message {
	public String message;
	
	public void  addNewMessage() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the your message: ");
		message = reader.readLine();
		Story story = new Story();
		story.addToStory(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		message = reader.readLine();
	}
	
}
