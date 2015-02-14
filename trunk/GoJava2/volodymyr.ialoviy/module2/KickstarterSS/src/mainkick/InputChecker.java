package mainkick;

import java.util.regex.Pattern;

public class InputChecker {
	private static int breakCounter;
	private static int magicStop = 3;
	
	private static Output out = new OutputConsole();
	private static Inputs in = new InputsConsole();
	
	public static int checkNumber(int[] border, String string){
		out.print(string);
		breakCounter = 0;
		int choiceNumber = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				if (stop()){
					checkNumber(border, in.enter());
				}
				string = in.enter();
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				if (stop()){
					checkNumber(border, in.enter());
				}
				string = in.enter();
				continue;
				}
			choiceNumber = Integer.valueOf(string);
			if (checkBorder(choiceNumber, border)){
				breakCounter++;
				if (stop()){
					checkNumber(border, in.enter());
				}
				string = in.enter();
				continue;
				}
			break;
		}
		out.print(Integer.toString(choiceNumber));
		return choiceNumber;
	}

	public static String checkName(String string){
		breakCounter = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
			}
			if (!checkIsName(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
				}
			break;
		}
		return string;
	}

	public static long checkCard(String string){
		breakCounter = 0;
		long cardNumber = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
				}
			if (!checkIsCard(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
				}
			cardNumber = Long.valueOf(string);
			break;
		}
		return cardNumber;
	}
	
	public static int checkAmount(String string){
		breakCounter = 0;
		int amount = 0;
		for (int i = 0; i < magicStop; i++){
			if (isNull(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
			}
			if (checkNumbers(string)){
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
				}
			if (!checkAmounter(string)){
				
				breakCounter++;
				if (stop()){
					checkName(in.enter());
				}
				string = in.enter();
				continue;
				}
			amount = Integer.valueOf(string);
			break;
		}
		return amount;
	}
	
	private static Boolean stop() {
		Boolean b = false;
		if (breakCounter == magicStop){
			out.print("You have used three attempts, try ten minutes");
			bannedFor10Minutes();
			b = true;
		}
		return b;
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
	
	private static void bannedFor10Minutes() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean checkIsNumber(String string){//TODO СДЕЛАТЬ один метод
        return Pattern.compile("^[-0-9]{1,3}$").matcher(string).matches();  
    }

	private static boolean checkIsName(String string){
		out.print("The name must be from two to twenty letters, please try again");
        return Pattern.compile("^[A-Za-z]{2,20}$").matcher(string).matches();  
    }

	private static boolean checkIsCard(String string){
		out.print("Card number card must bіt 16 numeric characters, please try again");
        return Pattern.compile("^[0-9]{16}$").matcher(string).matches();  
    }
	
	private static boolean checkAmounter(String string){
		out.print("Amount must by number, please try again");
        return Pattern.compile("^[0-9]{1,10}$").matcher(string).matches();  
    }
}
