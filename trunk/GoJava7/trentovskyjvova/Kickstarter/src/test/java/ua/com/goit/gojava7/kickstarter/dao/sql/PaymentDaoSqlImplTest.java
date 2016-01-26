package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@RunWith(MockitoJUnitRunner.class)
public class PaymentDaoSqlImplTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private PaymentDao paymentDaoMySqlImpl = new PaymentDaoSqlImpl();

	@Test
	@Ignore
	public void testAddPayment() {

		paymentDaoMySqlImpl.addPayment(new Payment());
		verify(jdbcTemplate).update(contains("INSERT INTO payment"), any(Integer.class), anyString(), anyString(),
				any(Integer.class));
	}

}
