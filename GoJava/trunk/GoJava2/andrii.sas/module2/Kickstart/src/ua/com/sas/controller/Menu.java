package ua.com.sas.controller;

import ua.com.sas.view.*;

public abstract class Menu {
	
	private Input input;
	private View view;
	private int checkedValue;


	public Menu(Input input, View view){
		this.input = input;
		this.view = view;
	}
	
	public int checkForEnteringLetters(){
		int l = 0;
		while(true){
			try {
				l = Integer.parseInt(input.readChoice());
				break;
			} catch (Exception e){
				view.println("Error!! You must enter numbers! - Try again:");
			}
		}
		return l;
	}
	
	public int getCheckedValue() {
		return checkedValue;
	}
	
	public void run (int size){
		while (true){
			displayItems();
			int enteredValue = checkForEnteringLetters();
			if (enteredValue == 0){
				break;
			} else {
				while(enteredValue < 0 || enteredValue > size){
					displayError();
					enteredValue = checkForEnteringLetters();
				}
				if (enteredValue == 0){
					break;
				} else {
					checkedValue = enteredValue;
					displaySelectedItems();
				}
				toNextLevel();
			}
		}
	}
	
	public abstract void displayItems();
	
	public abstract void displaySelectedItems();
	
	public abstract void displayError();
	
	public abstract void toNextLevel();
	
	
}
