package com.go_java4.alex_mirn.input_output.printers;

public class ConsolePrinter implements Printer {

	@Override
	public void print(String string) {
		System.out.print(string);
	}

	@Override
	public void println(String string) {
		print(string + "\n");
	}

}
