package ua.com.goit.gojava2.vova.kickstarter.util;

import java.util.regex.Pattern;

public class InputChecker {
	public static Boolean checkNumber(int[] border, String string){
		if (isNull(string)){
			return false;
		}
		if (checkNumbers(string)){
			return false;
		}
		int choiceNumber = Integer.valueOf(string);
		if (checkBorder(choiceNumber, border)){
			return false;
		}
		return true;
	}

	public static Boolean checkName(String string){
		if (isNull(string)){
			return false;
		}
		if (checkIsName(string)){
			return false;
		}
		return true;
	}

	public static Boolean checkCard(String string){
		if (isNull(string)){
			return false;
		}
		if (checkIsCard(string)){
			return false;
		}
		return true;
	}
	
	public static Boolean checkAmount(String string){
		if (isNull(string)){
			return false;
		}
		if (checkNumbers(string)){
			return false;
			}
		if (checkAmounter(string)){
			return false;
		}
		return true;
	}

	private static boolean isNull(String chosen) {
		boolean b = false;
		if (chosen.length() == 0 || chosen == null || chosen.isEmpty()){
			b = true;
		}
		return b;
	}
	
	private static Boolean checkBorder(int choiceNumber, int[] border){
		boolean f = false;
		if (!checkRangeOfNumbers(choiceNumber, border)){
			f = true;
		}
		return f;
	}
	
	private static Boolean checkNumbers(String chosen){
		boolean f = false;
		if (!pattern(chosen, "^[-0-9]{1,3}$")){
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
	
	private static boolean checkIsName(String string){
		boolean b = true;
		if (pattern(string, "^[A-Za-z]{2,20}$")){
			b = false;
		}
		return b;
    }

	private static boolean checkIsCard(String string){
		boolean b = true;
		if (pattern(string, "^[0-9]{16}$")){
			b = false;
		}
		return b;
    }
	
	private static boolean checkAmounter(String string){
		boolean b = true;
		if (pattern(string, "^[0-9]{1,10}$")){
			b = false;
		}
		return b;
    }
	
	private static boolean pattern(String string, String pattern){
        return Pattern.compile(pattern).matcher(string).matches();  
    }
}
