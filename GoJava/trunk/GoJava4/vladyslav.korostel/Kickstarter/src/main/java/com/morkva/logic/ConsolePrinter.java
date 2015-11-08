package com.morkva.logic;

public class ConsolePrinter implements Printer {

	@Override
	public void print(Object o) {
		System.out.print(o.toString());
	}

}
