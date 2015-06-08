package ua.com.gojava4.kickstarter.view;

import ua.com.gojava4.kickstarter.control.KickstarterController;

public class PageController implements KickstarterController {

	Reader reader; 
	Writer writer;
	
	public PageController(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public Page selectNextPage(Page currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
