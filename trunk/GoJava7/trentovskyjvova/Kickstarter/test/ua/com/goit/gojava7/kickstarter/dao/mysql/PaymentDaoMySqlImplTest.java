package ua.com.goit.gojava7.kickstarter.dao.mysql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentDaoMySqlImplTest {
	@Mock
	private Connection connection = mock(Connection.class);
	
	@InjectMocks
	private PaymentDao paymentDaoMySqlImpl = new PaymentDaoMySqlImpl(connection);
	
	@Test
	public void testGetPayments() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("cardNumber")).thenReturn("2341 2344 4334 3222");

		List<Payment> payments = paymentDaoMySqlImpl.getPayments(1);

		assertThat(payments.get(0).getCardNumber(), is("2341 2344 4334 3222"));
	}
	
	@Test
	public void testAddPayment() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeUpdate()).thenReturn(1);
		
		paymentDaoMySqlImpl.addPayment(new Payment());
		
		verify(ps).executeUpdate();

	}
	
	@Test
	public void testGetPledged() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("pledged")).thenReturn(100);

		int pledged = paymentDaoMySqlImpl.getPledged(1);

		assertThat(pledged, is(100));
	}
}
