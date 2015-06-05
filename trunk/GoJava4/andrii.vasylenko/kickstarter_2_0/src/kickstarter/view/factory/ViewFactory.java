package kickstarter.view.factory;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.UnknownStateException;
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

	private Printer printer;
	private Reader reader;

	public ViewFactory(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	@Override
	public View getInstance(State state) throws UnknownStateException {
		if (state == START) {
			return new StartView(printer, reader);
		} else if (state == QUOTE) {
			return new QuoteView(printer, reader);
		} else if (state == CATEGORIES) {
			return new CategoriesView(printer, reader);
		} else if (state == PROJECTS) {
			return new ProjectsView(printer, reader);
		} else if (state == PROJECT) {
			return new ProjectView(printer, reader);
		} else if (state == ASK_QUESTION) {
			return new AskQuestionView(printer, reader);
		} else if (state == DONATE) {
			return new DonateView(printer, reader);
		} else if (state == PAYMENT) {
			return new PaymentView(printer, reader);
		} else if (state == AMOUNT) {
			return new AmountView(printer, reader);
		} else if (state == ERROR) {
			return new ErrorView(printer, reader);
		} else if (state == THE_END) {
			return new TheEndView(printer, reader);
		}
		throw new UnknownStateException("no such state");
	}
}
