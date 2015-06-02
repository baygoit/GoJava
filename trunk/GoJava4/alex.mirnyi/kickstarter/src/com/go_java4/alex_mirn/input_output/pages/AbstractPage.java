package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public abstract class AbstractPage implements IPage {
	protected Printer printer;
	protected Reader reader;
	private Repository repository;
	protected String header;
	protected String data;
	protected String footer;
	protected String exit;
	protected String error;
	public IPage previousPage;

	
	public AbstractPage(Printer printer, Reader reader, 
			Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.repository = repository;
		this.previousPage = null;
		header = "";
		data = "";
		footer = "---------------";
		exit = "Bye";
		error = "Invalid input number!!! Try again";
	}
	
}
