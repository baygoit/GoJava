package gojava;

public abstract class MenuTemplate{
	private InputCheck check;
	
	public MenuTemplate(InputCheck check){
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

	public abstract Object getObject(int choice);

	public abstract void nextSubmenu(Object object, int choice);

	public abstract void showPositions();
}

