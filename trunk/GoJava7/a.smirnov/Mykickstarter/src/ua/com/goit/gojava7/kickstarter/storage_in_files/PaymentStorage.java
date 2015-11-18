package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.templates.AbstractStorage;

public class PaymentStorage extends AbstractStorage<Payment> {
	
	public int getPayments(Project project) {
		List<Payment> allProjectPayments = getAll();
		
		if (allProjectPayments.size() == 0) {
			return 0;
		} else {
			
			int result = 0;		
			for (int index = 0; index < allProjectPayments.size(); index++) {
				Payment payment = allProjectPayments.get(index);
				if (payment.getProjectID() == project.getUniqueID()) {
					result += payment.getDonatingSum();
				}
			}
			
			return result;
		}
	}
}
