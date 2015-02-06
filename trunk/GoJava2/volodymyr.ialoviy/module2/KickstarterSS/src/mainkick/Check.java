package mainkick;

import java.io.IOException;
import java.util.regex.Pattern;

public class Check {
	int breakCounter;
	int choiceNumber;
	public InputsConsole choice;
	public OutputConsole out;
	public Check(InputsConsole choice, OutputConsole out){
		this.choice = choice;
		this.out = out;
	}

	public int checkNumber(int[] border, boolean yes) throws IOException{
		int magicStop = 3;
		breakCounter = 0;
		choiceNumber = 0;
		for (int i = 0; i < magicStop; i++){
			String chosen = choice.enter();
			if (checkNumber(chosen)){continue;}
			choiceNumber = Integer.valueOf(chosen);
			if (checkZero(choiceNumber, yes)){continue;}
			if (checkBorder(choiceNumber, border)){continue;}
			break;
		}
		if (breakCounter == 3){
			out.print("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
		}
		return choiceNumber;
	}
	
	private Boolean checkBorder(int choiceNumber, int[] border){
		boolean f = false;
		if (!checkRangeOfNumbers(choiceNumber, border)){
			out.print("This number does not exist, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private Boolean checkZero(int choiceNumber, Boolean yes){
		boolean f = false;
		if (choiceNumber == 0 && yes){
			out.print("This number does not exist, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private Boolean checkNumber(String chosen){
		boolean f = false;
		if (!checkIsNumber(chosen)){
			out.print("It is not a number, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private boolean checkRangeOfNumbers(int number, int[] border){
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

	private boolean checkIsNumber(String string){  
        return Pattern.compile("^[-0-9]{1,3}$").matcher(string).matches();  
    }

}
