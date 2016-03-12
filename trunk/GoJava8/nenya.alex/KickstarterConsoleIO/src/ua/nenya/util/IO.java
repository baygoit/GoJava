package ua.nenya.util;

import java.util.List;

public interface IO {
	void writeln(String str);


	void write(String str);

	String readConsole();

	List<String> read(String fileName);

	void writeFile(String fileName, String str);

	
}
