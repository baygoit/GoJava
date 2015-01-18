import java.util.Scanner;


public class Menu {
	public void ask(){
		System.out.println("Choose action: \n1- Add new country\n2- Show visited countries\n");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice){
		case (1):
			System.out.println("Choose a country:");
			WorldMap.showCountries();
			choice = scanner.nextInt();
			Visited.addCountry(WorldMap.getCountry(choice-1));
			break;
		case (2):
			Visited.showCountries();
			break;
		}
	}
}
