package kickstarter.model.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaymentVariantTest {
	@Test
	public void shouldGetTheSamePaymentVariant_whenNewPaymentVariant() {
		PaymentVariant paymentVariant = new PaymentVariant(7, 3, 500, "test description");
		assertEquals(7, paymentVariant.getId());
		assertEquals(3, paymentVariant.getProjectId());
		assertEquals(500, paymentVariant.getAmount());
		assertEquals("test description", paymentVariant.getDescription());
	}
}
