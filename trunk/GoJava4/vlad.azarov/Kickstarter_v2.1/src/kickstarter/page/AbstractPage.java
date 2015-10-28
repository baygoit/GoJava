package kickstarter.page;

import kickstarter.logic.ILogic;
import kickstarter.printer.Printer;
import kickstarter.reader.Reader;

public abstract class AbstractPage {
	private Printer printer;
	private Reader reader;
	private ILogic iLogic;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

}
