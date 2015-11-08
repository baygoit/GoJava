package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.Map;

import com.go_java4.alex_mirn.input_output.pages.State;

public interface Page {

	void run(Map<String, String> map) throws IOException;
	State makeChoice(Map<String, String> map) throws IOException;

}
