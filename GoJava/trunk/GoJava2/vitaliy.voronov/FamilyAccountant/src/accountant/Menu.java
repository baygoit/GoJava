package accountant;

public class Menu {
	public void ask(){
		System.out.println("Выберите операцию:\n 1-внести расход \n 2- внести доход \n 3- увидеть бюджет ");
		Input input = new Input();
		int a = input.choise();
		switch (a){
			case (1):
				RecordList.addList();
				break;
			case (2):
				Budget.getSum();
				break;
			
			case (3):
				RecordList.output();
				break;	
		}
	}
}
