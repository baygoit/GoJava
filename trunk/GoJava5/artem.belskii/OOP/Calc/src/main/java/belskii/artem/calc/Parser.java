package belskii.artem.calc;

import java.util.ArrayList;

public class Parser {

	String SPLITTER=" ";
	public String [] convert(String rawValue) {
		return rawValue.split(SPLITTER);
	}
	
	public boolean validate(String [] expression){
		return true;
		
	}

}
