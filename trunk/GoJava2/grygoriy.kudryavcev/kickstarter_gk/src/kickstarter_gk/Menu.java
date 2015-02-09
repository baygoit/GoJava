package kickstarter_gk;

import java.util.ArrayList;

public class Menu {

	private int level;
	private Object object; 
	private int position;
	
	
	public Object getLevelMenu (int level, Object object, int position){
		this.level = level;
		this.object = object;
		this.position = position;
		
		if (level == 0 && position == 0){
			
			
			return object;
		}
		
		return  object;
		
	}
}
