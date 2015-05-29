package kickstarter.view;

import java.io.IOException;
import java.util.List;

import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public abstract class ConsoleView implements View {
	private Printer printer;
	private Reader reader;

	public ConsoleView(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	@Override
	public void view(List<String> data) {
		view(getHead());
		view(getBody(data));
		view(getMenu());
	}

	protected abstract String getHead();

	protected String getBody(List<String> data) {
		StringBuilder result = new StringBuilder();

		for (String line : data) {
			result.append(line);
			result.append("\r\n");
		}

		return result.toString();
	}

	protected abstract String getMenu();

	@Override
	public int choiceItem() {
		try {
			return Integer.parseInt(reader.getLine());
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	protected void view(String line) {
		printer.showMessage(line);
	}
}
