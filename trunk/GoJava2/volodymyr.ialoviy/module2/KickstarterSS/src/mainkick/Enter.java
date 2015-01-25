package mainkick;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Enter {
	public int enter() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String choiceString = reader.readLine();
		int choice = Integer.valueOf(choiceString);
		return choice;
	}
}
