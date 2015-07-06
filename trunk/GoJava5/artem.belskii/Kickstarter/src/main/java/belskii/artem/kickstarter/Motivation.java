package belskii.artem.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Motivation {
	ArrayList motivationList = new ArrayList();

	public void addMotivation(String text){
		motivationList.add(text);	
	}
	
	public String getMotivation(int id){
		return (String) motivationList.get(id);
	}
	
}
