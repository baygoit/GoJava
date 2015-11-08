package kickstarter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.model.dao.DAO;
import kickstarter.model.engine.Project;

public class PaymentModel implements Model {
	private DAO dao;
	private List<Object> parameters;
	private int amount;
	private int projectId;

	@Override
	public void init(DAO dao, List<Object> parameters) {
		this.dao = dao;
		this.parameters = new ArrayList<Object>(parameters);
		this.amount = (int) parameters.get(0);
		Project project = (Project) parameters.get(1);
		this.projectId = project.getId();
	}

	@Override
	public List<String> getData() {
		List<String> result = new ArrayList<>();

		result.add(String.format("amount = %d", amount));

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws SQLException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 1) {
			dao.donate(projectId, amount);
		}

		result.remove(0);

		return result;
	}
}
