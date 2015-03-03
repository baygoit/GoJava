package com.goit.kickstarter.service;

public abstract class Menu {
	private InputCheck check;
	
	public Menu(InputCheck check){
		this.check=check;
	}

	public void run(int length) {
		while(true){
			showPositions();
			
			int choice = check.menuInputCheck(length);
			if(choice==0){break;}
			
			Object object = getObject(choice);
			nextSubmenu(object, choice);
		}
	}

	abstract Object getObject(int choice);

	abstract void nextSubmenu(Object object, int choice);

	abstract void showPositions();
}
