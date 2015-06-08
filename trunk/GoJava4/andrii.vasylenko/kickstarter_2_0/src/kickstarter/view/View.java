package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.exception.ProcessedException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public interface View {
	void init(Printer printer, Reader reader);

	void view(List<String> data);

	int choiceItem(StringBuilder input) throws ProcessedException;

	State getDirection(int item) throws ProcessedException;
}
