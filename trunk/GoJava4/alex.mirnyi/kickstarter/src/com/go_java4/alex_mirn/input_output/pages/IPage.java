package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.Map;

import com.go_java4.alex_mirn.input_output.pages.State;

public interface IPage {

	public void run(Map<String, String> map) throws IOException;
	public State makeChoice(Map<String, String> map) throws IOException;

}
