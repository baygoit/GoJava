package belskii.artem.kickstarter;

import java.util.ArrayList;
import java.util.Random;

public class Motivation {
	ArrayList motivationList = new ArrayList();

	public void addMotivation(String text){
		motivationList.add(text);	
	}
	
	public String getMotivation(){
		Random rand = new Random();
		return (String) motivationList.get(rand.nextInt(motivationList.size()));
	}
	
}
