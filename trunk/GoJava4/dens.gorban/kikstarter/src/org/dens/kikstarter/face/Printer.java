package org.dens.kikstarter.face;

public interface Printer {
	
	void printBlock(String header, String ... options);
	
	void printLine(String text, boolean decorate);

	void printOption(int index, String text);

	void printHeader(String text);

}
