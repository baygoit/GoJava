package mainkick;

import java.util.regex.Pattern;

public class Check {
	
	public void checkString(String string){
		
	}

	public void checkNumber(int number){
		if (!checkEqual(number)){
			Output out = new OutputConsole();
			out.print("Wrong number");
		}
	}
	
	public boolean checkEqual(int number){  
        return Pattern.compile("^[0-9]{1,1}$").matcher(number).matches();  
    }
}
