package belskii.artem.calc;

import java.util.ArrayList;

public class Parser {

	String SPLITTER = " ";

	public String[] convert(String rawValue) {
		return rawValue.split(SPLITTER);
	}

	public boolean validate(String[] expression) {
		String REGEXP = "[0-9]+";
		Boolean answer = false;
		if (expression[0].matches(REGEXP) && expression[2].matches(REGEXP)) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;

	}

}
