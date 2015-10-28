
public class Main {
	static Menu menu = new Menu();
	
	public static void main(String[] args) {		
		while(true){
			menu.options();
			menu.ask();
		}
	}
}