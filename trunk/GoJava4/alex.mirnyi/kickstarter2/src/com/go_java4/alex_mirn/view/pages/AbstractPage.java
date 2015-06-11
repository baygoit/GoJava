package com.go_java4.alex_mirn.view.pages;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.view.io.IO;

public abstract class AbstractPage implements Page {
	protected IO io;
	public Dao repository;
	protected String header;
	protected String data;
	protected String footer;
	protected String exit;
	protected String error;
	public Page previousPage;

	
	public AbstractPage(IO io, 
			Dao repository) {
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
