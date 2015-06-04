package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.input_output.io.IO;

public abstract class AbstractPage implements Page {
	protected IO io;
	private Repository repository;
	protected String header;
	protected String data;
	protected String footer;
	protected String exit;
	protected String error;
	public Page previousPage;

	
	public AbstractPage(IO io, 
			Repository repository) {
		this.io = io;
		this.repository = repository;
		this.previousPage = null;
		header = "";
		data = "";
		footer = "---------------";
		exit = "Bye";
		error = "Invalid input number!!! Try again";
	}
	
}
