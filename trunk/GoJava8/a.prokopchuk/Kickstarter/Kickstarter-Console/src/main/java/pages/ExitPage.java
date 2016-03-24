package pages;

import com.anmertrix.ViewPage;

public class ExitPage implements Page {

	@Override
	public void viewPage(ViewPage viewPage) {
		viewPage.io.println(SOLID_LINE);
		viewPage.io.println("GoodBay!");
		viewPage.io.println(SOLID_LINE);
		viewPage.setExit(true);
	}

}
