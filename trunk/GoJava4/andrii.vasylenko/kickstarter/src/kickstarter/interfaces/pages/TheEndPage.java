package kickstarter.interfaces.pages;

public class TheEndPage implements Page {

	@Override
	public String getHead() {
		return "---------";
	}

	@Override
	public String getBody() {
		return "Good Luck!";
	}

}
