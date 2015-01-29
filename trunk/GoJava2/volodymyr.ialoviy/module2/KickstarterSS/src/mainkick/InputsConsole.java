package mainkick;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class InputsConsole implements Inputs{
	public int enter() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String choiceString = reader.readLine();
		String choice = choiceString;
		
		int choiceNumber = Integer.valueOf(choice);
		return choiceNumber;
	}
	

}
