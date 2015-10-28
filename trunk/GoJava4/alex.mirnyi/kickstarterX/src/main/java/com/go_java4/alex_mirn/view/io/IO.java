package com.go_java4.alex_mirn.view.io;

import java.io.IOException;

public interface IO {
	
	void print(String string);

	void println(String string);
	
	int readline() throws IOException;
}
