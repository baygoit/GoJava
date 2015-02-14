package myRealization;

public abstract class Menu {
	
	private Input input;
	private Output output;
	private int checkedValue;


	public Menu(Input input, Output output){
		this.input = input;
		this.output = output;
	}
	
	public int checkForEnteringLetters(){
		int l = 0;
		while(true){
			try {
				l = input.readChoice();
				break;
			} catch (Exception e){
				output.println("Error!! You must enter numbers! - Try again:");
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
					checkedValue = enteredValue - 1;
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
