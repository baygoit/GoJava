package gojava;

import gojava.Interface.IO;
import gojava.Interface.Menu;

public class Kickstarter {

	private IO io;
	private Menu menu;
	
	public Kickstarter(IO io, Menu menu){
		this.io=io;
		this.menu=menu;
	}

	public void run() {
		io.out("Welcome to the place where your dreams become real possibilities! ;)\n");

		menu.categoriesMenu();
		
		io.out("Good bye! :)");
	}
}
