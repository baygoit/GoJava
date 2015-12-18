package ua.com.goit.gojava7.kickstarter.dao.sql;

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

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.PaymentDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@RunWith(MockitoJUnitRunner.class)
public class PaymentDaoSqlImplTest {
	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DataSource dataSource = mock(DataSource.class);
	@InjectMocks
	private PaymentDao paymentDaoMySqlImpl = new PaymentDaoSqlImpl();
	
	@Test
	public void testGetPayments() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
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
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeUpdate()).thenReturn(1);
		
		paymentDaoMySqlImpl.addPayment(new Payment());
		
		verify(ps).executeUpdate();

	}
	
	@Test
	public void testGetPledged() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("pledged")).thenReturn(100);

		int pledged = paymentDaoMySqlImpl.getPledged(1);

		assertThat(pledged, is(100));
	}
}
