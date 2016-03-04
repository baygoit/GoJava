package ua.nenya.alex.util;

import java.util.List;

public interface IO {
	void writeln(String str);


	void write(String str);

	void writeEmpty();

	String readConsole();

	List<String> read(String fileName);

	void writeFile(String fileName, String str);

	
}
