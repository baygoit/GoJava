package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.ProjectsLogic;
import com.go_java4.alex_mirn.logic.ILogic;

public abstract class AbstractPage {
	private Printer printer;
	private Reader reader;
	private ILogic iLogic;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;
	
//	public AbstractPage(Printer printer, Reader reader, ILogic iLogic) {
//		this.printer = printer;
//		this.reader = reader;
//		this.iLogic = iLogic;
//		header = "";
//		data = "";
//		footer = "---------------";
//		exit = "";
//		error = "Invalid input number!!! Try again";
//	}
}
