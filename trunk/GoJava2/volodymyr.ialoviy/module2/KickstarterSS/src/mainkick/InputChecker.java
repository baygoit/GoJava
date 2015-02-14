package mainkick;

import java.util.regex.Pattern;

public class InputChecker {
	private int breakCounter;
	private int choiceNumber;
	private int magicStop = 3;
	private InputsConsole choice;
	private OutputConsole out;
	public InputChecker(InputsConsole choice, OutputConsole out){
		this.choice = choice;
		this.setOut(out);
	}

	public int checkNumber(int[] border){
		breakCounter = 0;
		choiceNumber = 0;
		for (int i = 0; i < magicStop; i++){
			String chosen = choice.enter();
			if (checkNumbers(chosen)){continue;}
			choiceNumber = Integer.valueOf(chosen);
			if (checkBorder(choiceNumber, border)){continue;}
			break;
		}
		if (breakCounter == magicStop){
			getOut().print("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
		}
		return choiceNumber;
	}
	
	public String checkName(){
		breakCounter = 0;
		String chosen = null;
		for (int i = 0; i < magicStop; i++){
			chosen = choice.enter();
			if (!checkIsName(chosen)){
				getOut().print("The name must be from two to twenty letters, please try again");
				breakCounter++;
				continue;
				}
			break;
		}
		if (breakCounter == magicStop){
			getOut().print("You have used three attempts, try ten minutes");
			chosen = Integer.toString(bannedFor10Minutes());
			return chosen;
		}
		return chosen;
	}
	
	public long checkCard(){
		breakCounter = 0;
		long cardNumber = 0;
		for (int i = 0; i < magicStop; i++){
			String chosen = choice.enter();
			if (!checkIsCard(chosen)){
				getOut().print("Card number card must bіt 16 numeric characters, please try again");
				breakCounter++;
				continue;
				}
			cardNumber = Long.valueOf(chosen);
			break;
		}
		if (breakCounter == magicStop){
			getOut().print("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
			return choiceNumber;
		}
		return cardNumber;
	}
	
	public int checkAmount(){
		breakCounter = 0;
		int amount = 0;
		for (int i = 0; i < magicStop; i++){
			String chosen = choice.enter();
			if (!checkAmount(chosen)){
				getOut().print("Amount must by number, please try again");
				breakCounter++;
				continue;
				}
			amount = Integer.valueOf(chosen);
			break;
		}
		if (breakCounter == magicStop){
			getOut().print("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
		}
		return amount;
	}
	
	private Boolean checkBorder(int choiceNumber, int[] border){
		boolean f = false;
		if (!checkRangeOfNumbers(choiceNumber, border)){
			getOut().print("This number does not exist, please try again");
			breakCounter++;
			f = true;
		}
		return f;
	}
	
	private Boolean checkNumbers(String chosen){
		boolean f = false;
		if (!checkIsNumber(chosen)){
			getOut().print("It is not a number, please try again");
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

	private boolean checkIsName(String string){  
        return Pattern.compile("^[A-Za-z]{2,20}$").matcher(string).matches();  
    }

	private boolean checkIsCard(String string){  
        return Pattern.compile("^[0-9]{16}$").matcher(string).matches();  
    }
	
	private boolean checkAmount(String string){  
        return Pattern.compile("^[0-9]{1,10}$").matcher(string).matches();  
    }

	public OutputConsole getOut() {
		return out;
	}

	public void setOut(OutputConsole out) {
		this.out = out;
	}
}
