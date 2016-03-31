package com.anmertrix.page;

import com.anmertrix.ViewPage;

public interface Page {
	
	static final int EXIT_INPUT = 0;
	static final String SOLID_LINE = "─────────────────────────────────────────";
	void viewPage(ViewPage viewPage);

}
