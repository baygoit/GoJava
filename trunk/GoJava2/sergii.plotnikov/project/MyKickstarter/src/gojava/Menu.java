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
	
	
}
