package categories;

public interface DAO {
	
	Category loadBase();
	void sendMoney(int id, int money, String card);
	void sendMassage(int id, String author, String text);

}
