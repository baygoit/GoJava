package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.anmertrix.domain.Payment;

@RunWith(MockitoJUnitRunner.class)
public class PaymentDaoSqlTest {
	
	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@Mock
	Payment payment;
	@InjectMocks
	private PaymentDaoSql paymentDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}
	
	@Ignore
	@Test
	public void testGetPaymentsByProjectId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("cardholder_name")).thenReturn("test cardholder name");
		when(resultSet.getInt("amount")).thenReturn(100);
		List<Payment> payments = paymentDaoSql.getPaymentsByProjectId(1);
		Payment payment = payments.get(0);
		assertThat(payment.getId(), is(1));
		assertThat(payment.getCardholderName(), is("test cardholder name"));
		assertThat(payment.getAmount(), is(100));
	}
	
	@Ignore
	@Test
	public void testInsertPayment() throws SQLException {
		paymentDaoSql.insertPayment(payment);
		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(2)).setString(anyInt(), anyString());
		verify(preparedStatement, times(2)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
	}

}
