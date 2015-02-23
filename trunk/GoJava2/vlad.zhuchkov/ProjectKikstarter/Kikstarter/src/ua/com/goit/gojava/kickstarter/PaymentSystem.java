package ua.com.goit.gojava.kickstarter;

import ua.com.goit.gojava.kickstarter.in_memory_storage.Project;



public class PaymentSystem {

	public static void pay(Project selectedProject, int amount) {
		selectedProject.increaseAmount(amount);
		
	}

}
