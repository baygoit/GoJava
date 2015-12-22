package ua.com.goit.gojava7.kickstarter.dao;

public class Main {

	public static void main(String[] args) {
		DbDao dbDao = new DbDao();
System.out.println(dbDao.getTop5ProjectsByPledged("select sum(amount) as sum, project_id as projectId from payment group by project_id order by sum desc"));
	}

}
