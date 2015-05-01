package kickstarter;

public class Project {
	String name = "null";
	String description="null";
	String history="null";
	int id;
	int goal;
	int money;
	int expireDate;

	Project(int id) {
		setId(id);
	}

	void setHistory(String history) {
		this.history = history;
	}

	String getHistory() {
		return history;
	}

	void setDescription(String Description) {
		this.description = Description;
	}

	String getDescription() {
		return description;
	}

	int getExpire() {
		return expireDate;
	}

	void setExpire(int expire) {
		this.expireDate = expire;
	}

	void setMoney(int money) {
		this.money = money;
	}

	int getMoney() {
		return money;
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setId(int id) {
		this.id = id;
	}

	int getId() {
		return id;
	}

	int getGoal() {
		return goal;
	}

	void setGoal(int goal) {

	}

}
