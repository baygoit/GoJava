package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
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

	@Test
	public void testGetPaymentsByProjectIdNotFound() throws SQLException {
		List<Payment> payments = paymentDaoSql.getPaymentsByProjectId(1);
		assertThat(payments.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			paymentDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			paymentDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			paymentDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testInsertPayment() throws SQLException {
		paymentDaoSql.insertPayment(payment);
		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(2)).setString(anyInt(), anyString());
		verify(preparedStatement, times(2)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertPaymentGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			paymentDaoSql.insertPayment(payment);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertPaymentCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			paymentDaoSql.insertPayment(payment);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
			verify(connection).close();
		}
	}

}
