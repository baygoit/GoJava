package com.goit.kickstarter.service;

import java.util.InputMismatchException;

import com.goit.kickstarter.view.ConsoleIO;

public class InputCheck {
	private ConsoleIO io;
	
	public InputCheck(ConsoleIO io){
		this.io=io;
	}
	
	public int menuInputCheck(int length){
		try{
			int choice=io.input();
			if (choice<0||choice>length){
				io.out("Wrong input!!!\nChoose again!");
				return menuInputCheck(length);
			}else{
				return choice;
			}
		} catch(InputMismatchException ex){
			io.out("Wrong input!!!\nChoose again!");
			return menuInputCheck(length);
		}
	}

	public String stringInputCheck() {
		String input = io.stringInput();
		if(input.equals("0")){
			return "0";
		}else if (input.equals("")){
			io.out("Wrong input!!!\nType again!");
			return stringInputCheck();
		}else{
			return input;
		}
	}
}
