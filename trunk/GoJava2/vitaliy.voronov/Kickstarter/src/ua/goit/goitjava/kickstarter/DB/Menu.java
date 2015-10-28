package ua.goit.goitjava.kickstarter.DB;

import ua.goit.goitjava.kickstarter.IO;

public abstract class Menu {
	private IO io;
	
	public Menu(IO io) {
		this.io = io;
	}

	public void run( ){
		while(true){
			ask();
			
			int menu = Integer.parseInt(io.scan());
			if(menu == 0){
				break;
			}
			
			Object selected = choise(menu);
			if(selected == null){
				continue;
			}
			
			 Menu subMenu = nextMenu(selected);  
             if (subMenu != null) {
                     subMenu.run();
             }
		}
	}
	
	abstract Menu nextMenu(Object selected);

	abstract Object choise(int menu);

	abstract void ask();
}
