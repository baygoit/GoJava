package gojava;

import java.util.InputMismatchException;

public class Menu {

	public int menuInputCheck(IO io, int length){
		try{
			int choice=io.input();
			if (choice<0||choice>length){
				io.out("Wrong input!!!\nChoose again!");
				return menuInputCheck(io, length);
			}else{
				return choice;
			}
		} catch(InputMismatchException ex){
			io.out("Wrong input!!!\nChoose again!");
			return menuInputCheck(io, length);
		}
	}
	
	public String stringInputCheck(IO io){
		String input = io.stringInput();
		if (input.equals("")){
			io.out("Wrong input!!!\nType again!");
			return stringInputCheck(io);
		}else if(input.equals("0")){
			return "0";
		}else{
			return input;
		}
	}

	public String cardInputCheck(IO io) {
		String input = io.stringInput();
		if (input.equals("")||input.length()<16){
			io.out("Wrong card number!!!\nType again!");
			return cardInputCheck(io);
		}else if(input.equals("0")){
			return "0";
		}else{
			return input;
		}
	}
	
}
