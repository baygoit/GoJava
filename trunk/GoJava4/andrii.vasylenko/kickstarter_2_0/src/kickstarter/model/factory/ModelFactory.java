package kickstarter.model.factory;

import static kickstarter.control.State.*;

import java.util.List;

import kickstarter.control.State;
import kickstarter.exception.UnknownStateException;
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
import kickstarter.model.dao.CategoriesDAO;
import kickstarter.model.dao.PaymentsDAO;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.dao.QuestionsDAO;
import kickstarter.model.dao.QuotesDAO;

public class ModelFactory implements AbstractModelFactory {
	private QuotesDAO quotes;
	private CategoriesDAO categories;
	private ProjectsDAO projects;
	private QuestionsDAO questions;
	private PaymentsDAO payments;

	public ModelFactory(QuotesDAO quotes, CategoriesDAO categories, ProjectsDAO projects, QuestionsDAO questions,
			PaymentsDAO payments) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
		this.questions = questions;
		this.payments = payments;
	}

	@Override
	public Model getInstance(State state, List<Object> parameters) throws UnknownStateException {
		if (state == START) {
			return new StartModel();
		} else if (state == QUOTE) {
			return new QuoteModel(quotes);
		} else if (state == CATEGORIES) {
			return new CategoriesModel(categories);
		} else if (state == PROJECTS) {
			return new ProjectsModel(projects, parameters);
		} else if (state == PROJECT) {
			return new ProjectModel(projects, parameters);
		} else if (state == ASK_QUESTION) {
			return new AskQuestionModel(questions, parameters);
		} else if (state == DONATE) {
			return new DonateModel(payments, parameters);
		} else if (state == PAYMENT) {
			return new PaymentModel(payments, parameters);
		} else if (state == AMOUNT) {
			return new AmountModel(parameters);
		} else if (state == ERROR) {
			return new ErrorModel();
		} else if (state == THE_END) {
			return new TheEndModel();
		}
		throw new UnknownStateException("no such state");
	}
}
