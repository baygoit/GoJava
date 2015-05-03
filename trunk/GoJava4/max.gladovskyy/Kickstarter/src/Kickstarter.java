
public class Kickstarter {

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.run();
	}	
	
	private MainPage mainPage = MainPage.getMainPage();
	
	public void run() {
		mainPage.print();
	}

}
