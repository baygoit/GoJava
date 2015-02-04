package mainkick;

import java.io.IOException;
import java.util.regex.Pattern;

public class Check {
	int breakCounter;
	int choiceNumber;
	public InputsConsole choice;
	public Check(InputsConsole choice){
		this.choice = choice;
	}

	public int checkNumber(int[] border, boolean yes) throws IOException{
		breakCounter = 0;
		choiceNumber = 0;
		for (int i = 0; i < 3; i++){
			String chosen = choice.enter();
			if (number(chosen)){continue;}
			choiceNumber = Integer.valueOf(chosen);
			if (numberZero(choiceNumber, yes)){continue;}
			if (numberBorder(choiceNumber, border)){continue;}
			break;
		}
		if (breakCounter == 3){
			KickstarterS.printer("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
		}
		return choiceNumber;
	}
	
	private Boolean numberBorder(int choiceNumber, int[] border){
		boolean f = false;
		if (!rangeOfNumbers(choiceNumber, border)){
			KickstarterS.printer("This number does not exist, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private Boolean numberZero(int choiceNumber, Boolean yes){
		boolean f = false;
		if (choiceNumber == 0 && yes){
			KickstarterS.printer("This number does not exist, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private Boolean number(String chosen){
		boolean f = false;
		if (!isNumber(chosen)){
			KickstarterS.printer("It is not a number, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private boolean rangeOfNumbers(int number, int[] border){
		boolean f = false;
		for (int i = 0; i < border.length; i++){
			if (border[i] == number){
				f = true;
				break;
			}
		}
		if (number == 0){
			f = true;
		}
		return f;
    }
	
	private int bannedFor10Minutes() {
		// TODO
		int choiceNumber = 777;
		return choiceNumber;
	}

	private boolean isNumber(String string){  
        return Pattern.compile("^[0-9]{1,3}$").matcher(string).matches();  
    }

}
