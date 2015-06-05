package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.ProcessedException;
import kickstarter.model.dao.PaymentsDAO;
import kickstarter.model.engine.PaymentVariant;
import kickstarter.model.engine.Project;

public class DonateModel implements Model {
	private PaymentsDAO dao;
	private int projectId;
	private List<Object> parameters;

	public DonateModel(PaymentsDAO dao, List<Object> parameters) {
		this.dao = dao;
		this.parameters = new ArrayList<Object>(parameters);
		Project project = (Project) parameters.get(0);
		this.projectId = project.getId();
	}

	@Override
	public List<String> getData() throws ProcessedException {
		List<String> result = new ArrayList<>();
		
		for (PaymentVariant variant : dao.getPaymentVariants(projectId)) {
			result.add(addData(variant));
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws ProcessedException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 0) {
		} else if (item == 1){
			
		} else {
			int id = item - 1;
			PaymentVariant variant = dao.getPaymentVariant(id, projectId);
			result.add(0, variant.getAmount());
		}

		return result;
	}

	private String addData(PaymentVariant variant) {
		StringBuilder result = new StringBuilder();

		int item = variant.getId() + 1;
		result.append(item);
		result.append(" - ");

		result.append(variant.getAmount());
		result.append("$ ");

		result.append("(");
		result.append(variant.getDescription());
		result.append(")");

		return result.toString();	
	}
}
