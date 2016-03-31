package com.anmertrix.page;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;

public class ExitPage implements Page {
	
	@Override
	public void viewPage(ViewPage viewPage) {
		IO io = viewPage.getIo();
		io.println(SOLID_LINE);
		io.println("GoodBay!");
		io.println(SOLID_LINE);
		viewPage.setExit(true);
	}

}
