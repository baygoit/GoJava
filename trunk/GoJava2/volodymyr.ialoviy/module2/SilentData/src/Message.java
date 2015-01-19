import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Message {
	private static String message;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void  addNewMessage() throws IOException{
		System.out.println("Enter the your message: ");
		message = reader.readLine();
		Story.addToStory(message);
	}

	public static String getMessage() {
		return message;
	}

	public void setMessage() throws IOException {
		message = reader.readLine();
	}
	
	public static String getMyMessage(){
		return message;
	}
	
}
