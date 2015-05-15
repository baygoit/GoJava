package kickstarter.pages;


import kickstarter.ui.UserInterface;

public class WrongChoicePage extends Page{
	private UserInterface ui;
	public WrongChoicePage(UserInterface ui){
		this.ui=ui;
	}
	public void print(int[] parameterForPrint) {
		print();
	}

	public void print() {
		ui.display(" ");
		ui.display("----- Wrong Choice ----------");
		ui.display("input correct command, please");
		ui.display("-----------------------------");
		ui.display(" ");
	}
	public int[] getOptions() {
		return null;
	}
}
