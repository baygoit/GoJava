package ua.scread.cash;

public class CashAccounting {
//	1)	Добавить расход.
//	  А) Добавление заполнением формы
	//private static double balance = 0;
	
	public CashAccounting() {
		// TODO Auto-generated constructor stub
	}
	
	public static void timeCicle() {
		Transaction transaction = new Transaction(new Check("Salary", 2, 5.00), true);
		
		//transaction.send();
		
		System.out.println("Balance: " + Transactions.getInstance().getBalance());
		
		transaction = new Transaction(new Check("Apple", 1, 2), false);
		
		//transaction.send();
		
		System.out.println("Balance: " + Transactions.getInstance().getBalance());
		
	}
	
	public static void main(String[] args) {
			timeCicle();
	}
}