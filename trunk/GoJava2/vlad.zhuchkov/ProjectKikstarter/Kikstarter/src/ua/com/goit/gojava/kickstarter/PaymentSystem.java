package ua.com.goit.gojava.kickstarter;



public class PaymentSystem {

	public static void pay(Project selectedProject, int amount) {
		selectedProject.increaseAmount(amount);
		
	}

}
