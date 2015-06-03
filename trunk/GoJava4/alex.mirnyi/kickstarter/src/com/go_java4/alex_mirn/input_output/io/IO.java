package com.go_java4.alex_mirn.input_output.io;

import java.io.IOException;

public interface IO {
	
	public void print(String string);

	public void println(String string);
	
	public String readline() throws IOException;
}
