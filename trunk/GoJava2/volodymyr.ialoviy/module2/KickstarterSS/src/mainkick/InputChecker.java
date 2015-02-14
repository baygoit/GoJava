package mainkick;

import java.util.regex.Pattern;

public class InputChecker {
	private static int breakCounter;
	private static int magicStop = 3;
	
	private static OutputConsole out = new OutputConsole();
	
	public static int checkNumber(int[] border, String string){
		breakCounter = 0;
		int choiceNumber = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				continue;
				}
			choiceNumber = Integer.valueOf(string);
			if (checkBorder(choiceNumber, border)){
				breakCounter++;
				continue;
				}
			break;
		}
		if (breakCounter == magicStop){
			out.print("You have used three attempts, try ten minutes");
			choiceNumber = bannedFor10Minutes();
		}
		return choiceNumber;
	}

	public static String checkName(String string){
		breakCounter = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				continue;
			}
			if (!checkIsName(string)){
				out.print("The name must be from two to twenty letters, please try again");
				breakCounter++;
				continue;
				}
			break;
		}
		if (breakCounter == magicStop){
			out.print("You have used three attempts, try ten minutes");
			string = Integer.toString(bannedFor10Minutes());
			return string;
		}
		return string;
	}

	public static long checkCard(String string){
		breakCounter = 0;
		long cardNumber = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				continue;
				}
			if (!checkIsCard(string)){
				out.print("Card number card must bіt 16 numeric characters, please try again");
				breakCounter++;
				continue;
				}
			cardNumber = Long.valueOf(string);
			break;
		}
		if (breakCounter == magicStop){
			out.print("You have used three attempts, try ten minutes");
			cardNumber = bannedFor10Minutes();
			return cardNumber;
		}
		return cardNumber;
	}
	
	public static int checkAmount(String string){
		breakCounter = 0;
		int amount = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				continue;
				}
			if (!checkAmounter(string)){
				out.print("Amount must by number, please try again");
				breakCounter++;
				continue;
				}
			amount = Integer.valueOf(string);
			break;
		}
		if (breakCounter == magicStop){
			out.print("You have used three attempts, try ten minutes");
			amount = bannedFor10Minutes();
			return amount;
		}
		return amount;
	}
	
	private static boolean isNull(String chosen) {
		boolean b = false;
		if (chosen.length() == 0 || chosen == null || chosen.isEmpty()){
			out.print("You do not enter");
			b = true;
		}
		return b;
	}
	
	private static Boolean checkBorder(int choiceNumber, int[] border){
		boolean f = false;
		if (!checkRangeOfNumbers(choiceNumber, border)){
			out.print("This number does not exist, please try again");
			f = true;
		}
		return f;
	}
	
	private static Boolean checkNumbers(String chosen){
		boolean f = false;
		if (!checkIsNumber(chosen)){
			out.print("It is not a number, please try again");
			f = true;
		}
		return f;
	}
	
	private static boolean checkRangeOfNumbers(int number, int[] border){
		boolean f = false;
		for (int i = 0; i < border.length; i++){
			if (border[i] == number){
				f = true;
				break;
			}
		}
		return f;
    }
	
	private static int bannedFor10Minutes() {
		// TODO
		int choiceNumber = 777;
		return choiceNumber;
	}

	private static boolean checkIsNumber(String string){//TODO СДЕЛАТЬ один метод
        return Pattern.compile("^[-0-9]{1,3}$").matcher(string).matches();  
    }

	private static boolean checkIsName(String string){  
        return Pattern.compile("^[A-Za-z]{2,20}$").matcher(string).matches();  
    }

	private static boolean checkIsCard(String string){  
        return Pattern.compile("^[0-9]{16}$").matcher(string).matches();  
    }
	
	private static boolean checkAmounter(String string){  
        return Pattern.compile("^[0-9]{1,10}$").matcher(string).matches();  
    }
}
