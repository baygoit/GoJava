package kickstarter;

public class Engine {
	private Output out = new Output();
	private Input input = new Input();
	private Quatation quatation = new Quatation();
	private Welcome welcome = new Welcome();

	private CategoryList categoryList = new CategoryList();
	private ProjectLists projectList = new ProjectLists();

	public void run() {
		quatation.quatation();
		welcome.welcome();
		
		while (true) {
			categoryList.showCategories();
			int choice = input.read();
			if (choice == 0) {break;}

			while (true) {
				if (choice == 0) {break;}
				out.print("You pick:  " + categoryList.getCategory(choice - 1)
						+ "  - good choice!\n");
				out.print("\n••••• Select one of these cool project: •••••\n");
				//вернуть значение или другой масив
				projectList.showProjects(choice);
				while (true) {
					choice = input.read();
					if (choice == 0) {break;}
					switch (choice) {
					case 1:
						projectList.showProjectFull(1);
						break;
					case 2:
						projectList.showProjectFull(2);
						break;
					default: out.print("No such project! Please choose another one!");
					break;
					}
					
				}


			}


		}

	}
}
