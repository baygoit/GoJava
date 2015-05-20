package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.view.ConsoleInputReader;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class InputControl {

    private Reader inputReader;

    public InputControl() {
	inputReader = new ConsoleInputReader();
    }

    public int readUserInput() {
	return inputReader.readUserInput();
    }
}
