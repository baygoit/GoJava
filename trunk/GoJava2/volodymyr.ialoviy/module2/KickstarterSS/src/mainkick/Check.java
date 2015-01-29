package mainkick;

import java.io.IOException;
import java.util.regex.Pattern;

public class Check {

	public int checkNumber() throws IOException{
		Output out = new OutputConsole();
		Inputs choice = new InputsConsole();
		int breakCounter = 0;
		int choiceNumber = 0;
		for (int i = 0; i < 3; i++){
			String chosen = choice.enter();
			if (!isNumber(chosen)){
				out.print("It is not a number, please try again");
				breakCounter++;
				continue;
			}
			choiceNumber = Integer.valueOf(chosen);
			if (!rangeOfNumbers(choiceNumber, 1, 3)){
				out.print("This number does not exist, please try again");
				breakCounter++;
				continue;
			}
		}
		if (breakCounter == 3){
			out.print("You have used three attempts, try ten minutes");
			bannedFor10Minutes();
		}
		return choiceNumber;
	}
	
	private void bannedFor10Minutes() {
		// TODO Auto-generated method stub
		
	}

	private boolean isNumber(String string){  
        return Pattern.compile("^[0-9]{1,5}$").matcher(string).matches();  
    }
	
	private boolean rangeOfNumbers(int number, int lower, int top){
		boolean f = true;
		if (!(number >= lower && number <= top)){
			f = false;
		}
		return f;
    }
	
}
