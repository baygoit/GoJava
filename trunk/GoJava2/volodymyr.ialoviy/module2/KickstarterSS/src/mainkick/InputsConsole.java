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
		if (!checkEqual(choice)){
			Output out = new OutputConsole();
			out.print("Wrong number");
		}
		int choiceNumber = Integer.valueOf(choice);
		return choiceNumber;
	}
	
	public boolean checkEqual(String userString){  
		//TODO
        return Pattern.compile("^[0-9]{1,1}$").matcher(userString).matches();  
    }
}
