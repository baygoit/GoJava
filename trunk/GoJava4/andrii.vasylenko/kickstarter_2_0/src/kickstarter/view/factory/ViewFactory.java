package kickstarter.view.factory;

import static kickstarter.control.State.*;

import java.util.HashMap;
import java.util.Map;

import kickstarter.control.State;
import kickstarter.view.AmountView;
import kickstarter.view.AskQuestionView;
import kickstarter.view.CategoriesView;
import kickstarter.view.DonateView;
import kickstarter.view.ErrorView;
import kickstarter.view.PaymentView;
import kickstarter.view.ProjectView;
import kickstarter.view.ProjectsView;
import kickstarter.view.QuoteView;
import kickstarter.view.StartView;
import kickstarter.view.TheEndView;
import kickstarter.view.View;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ViewFactory implements AbstractViewFactory {
	private static final Map<State, View> states = new HashMap<>();

	static {
		states.put(START, new StartView());
		states.put(QUOTE, new QuoteView());
		states.put(CATEGORIES, new CategoriesView());
		states.put(PROJECTS, new ProjectsView());
		states.put(PROJECT, new ProjectView());
		states.put(ASK_QUESTION, new AskQuestionView());
		states.put(DONATE, new DonateView());
		states.put(PAYMENT, new PaymentView());
		states.put(AMOUNT, new AmountView());
		states.put(ERROR, new ErrorView());
		states.put(THE_END, new TheEndView());
	}

	private Printer printer;
	private Reader reader;

	public ViewFactory(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	@Override
	public View getInstance(State state) {
		View view = states.get(state);
		view.init(printer, reader);
		return view;
	}
}
