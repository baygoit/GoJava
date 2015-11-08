package com.goit.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.goit.kickstarter.model.Payment;

@Component
public class PaymentDAO{
	
//	public void createPayment(Payment p) {
//		try (Connection connection = getConnection()){
//			String query = "INSERT into payments(name, card_number, amount, project)"
//					+"VALUES(?,?,?,?);";
//			
//			PreparedStatement stmt = connection.prepareStatement(query);
//			stmt.setString(1, p.getName());
//			stmt.setString(2, p.getCardNumber());
//			stmt.setInt(3, p.getAmount());
//			stmt.setInt(4, p.getProjId());
//			
//			stmt.executeUpdate();	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
