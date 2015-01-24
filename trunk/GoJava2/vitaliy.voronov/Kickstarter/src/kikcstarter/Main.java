package kikcstarter;

public class Main {

	public static void main(String[] args) {
		Output out = new Output();
		out.printLaoTzu();
		out.menu();
		
		Input in = new Input();
		switch (in.scanInt()){
			case 1:
				out.youChoose("education");
					break;
			case 2:
				out.youChoose("finance");
					break;
			case 3:
				out.youChoose("games");
		}	
	
	}

}
