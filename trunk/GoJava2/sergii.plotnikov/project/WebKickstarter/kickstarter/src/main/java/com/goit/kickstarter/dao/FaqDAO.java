package com.goit.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.goit.kickstarter.model.FAQ;

@Component
public class FaqDAO extends AbstractDAO{
	
	public FAQ getQA(int id) {
		FAQ faq = null;
		try (Connection connection = getConnection()){
			String query = "SELECT * FROM categories WHERE project =?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				faq = new FAQ(rs.getString("question"), rs.getString("answer"), rs.getInt("project"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return faq;
	}

	public void createFaq(FAQ faq) {
		try (Connection connection = getConnection()){
			String query = "INSERT into faq(question, answer, project)"
					+"VALUES(?,?,?);";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, faq.getQuestion());
			stmt.setString(2, faq.getAnswer());
			stmt.setInt(3, faq.getProjectId());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFaq(FAQ faq) {
		try (Connection connection = getConnection()){
			String query = "UPDATE faq SET answer=? "
					+ "WHERE project=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, faq.getAnswer());
			stmt.setInt(2, faq.getProjectId());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFaq(int id) {
		try (Connection connection = getConnection()){
			String query = "DELETE FROM faq WHERE id=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getLength() {
		int count=0;
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM faq";
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public List<FAQ> getFaq(int projectId) {
		List<FAQ> list = new ArrayList<FAQ>();
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM faq WHERE project=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, projectId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				list.add(new FAQ(rs.getString("question"), rs.getString("answer"), rs.getInt("project")));
			}
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return list;
	}
}
