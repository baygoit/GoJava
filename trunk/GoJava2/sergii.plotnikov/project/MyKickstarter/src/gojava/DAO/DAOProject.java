package gojava.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gojava.Payment;
import gojava.Interface.Payments;
import gojava.Interface.Project;

public class DAOProject implements Project{
	private String projectName;
	private String categoryName;
	
	public DAOProject(int i, String categoryName){
		this.categoryName=categoryName;
		
		Connection connection = null;
		int line=1;
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			String query = "select * from projects where category=\'"+this.categoryName+"\'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(line==i){
					this.projectName=rs.getString("project_name");
					break;
				}
				line++;
			}
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
	}
	

	@Override
	public String showProject() {
		Connection connection = null;
		String result = "";
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			String query = "select * from projects where project_name =\'"+projectName+"\'";
			ResultSet rs = stmt.executeQuery(query);
			String queryFaq = "select * from faq where project=\'"+projectName+"\'";
			
			
			while(rs.next()){
		        result+=rs.getString("project_name")+"\n"+
		        	rs.getString("description")+"\n"+
		        	"Money needed: " + rs.getString("value")+ 
		        	"; Money collected: " + rs.getString("recieved") + "\n"+
		        	"Days left: " + rs.getString("days")+ "\n";
			}
			ResultSet faq = stmt.executeQuery(queryFaq);
	        while(faq.next()){
	        	result+="Q: " + faq.getString("question")+"\n";
	        	if(faq.getString("answer")!=null){
	        		result+="A: " + faq.getString("answer")+"\n";
	        	}
	        }
	        result+="--------------------------"+"\n";
			result+="1 - Ask question\n2 - Invest\n0 - Go back\n";

			connection.close();
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}

		return result;
	}

	@Override
	public void addQuestion(String q) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			String query = "insert into faq (question, project) "
					+ "values (\'"+q+"\',\'"+projectName+"\');";
			stmt.executeUpdate(query);	
			
			stmt.close();
			connection.commit();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
	}

	@Override
	public int getRewardsLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRewardPrice(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makePayment(Payment p, int amount) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getPositionsLength() {
		return 2;
	}
	
	
	
	
	@Override
	public Payments getPayments() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShortDescr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shortProjectDescr() {
		// TODO Auto-generated method stub
		return null;
	}
}
