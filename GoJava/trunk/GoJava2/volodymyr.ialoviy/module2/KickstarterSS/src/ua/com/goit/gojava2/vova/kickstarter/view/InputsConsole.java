package ua.com.goit.gojava2.vova.kickstarter.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputsConsole implements Inputs{
	public String enter(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
