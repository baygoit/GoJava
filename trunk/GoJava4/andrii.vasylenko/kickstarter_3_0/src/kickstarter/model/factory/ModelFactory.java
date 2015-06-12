package kickstarter.model.factory;

import static kickstarter.control.State.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kickstarter.control.State;
import kickstarter.model.AmountModel;
import kickstarter.model.AskQuestionModel;
import kickstarter.model.CategoriesModel;
import kickstarter.model.DonateModel;
import kickstarter.model.ErrorModel;
import kickstarter.model.Model;
import kickstarter.model.PaymentModel;
import kickstarter.model.ProjectModel;
import kickstarter.model.ProjectsModel;
import kickstarter.model.QuoteModel;
import kickstarter.model.StartModel;
import kickstarter.model.TheEndModel;
import kickstarter.model.dao.DAO;

public class ModelFactory implements AbstractModelFactory {
	private static final Map<State, Model> states = new HashMap<>();

	static {
		states.put(START, new StartModel());
		states.put(QUOTE, new QuoteModel());
		states.put(CATEGORIES, new CategoriesModel());
		states.put(PROJECTS, new ProjectsModel());
		states.put(PROJECT, new ProjectModel());
		states.put(ASK_QUESTION, new AskQuestionModel());
		states.put(DONATE, new DonateModel());
		states.put(PAYMENT, new PaymentModel());
		states.put(AMOUNT, new AmountModel());
		states.put(ERROR, new ErrorModel());
		states.put(THE_END, new TheEndModel());
	}

	private DAO dao;

	public ModelFactory(DAO dao) {
		this.dao = dao;
	}

	@Override
	public Model getInstance(State state, List<Object> parameters) {
		Model model = states.get(state);
		model.init(dao, parameters);
		return model;
	}
}
