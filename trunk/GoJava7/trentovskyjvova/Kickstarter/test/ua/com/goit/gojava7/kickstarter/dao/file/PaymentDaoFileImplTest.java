package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.file.PaymentDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class PaymentDaoFileImplTest {
	private File testPaymentsFile;
	private PaymentDaoFileImpl paymentDaoFileImpl;

	@Test
	public void testGetPayments() {
		testPaymentsFile = new File("./resources/payments.csv");
		paymentDaoFileImpl = new PaymentDaoFileImpl(testPaymentsFile);
		assertThat(paymentDaoFileImpl.getPayments(12).size(), is(1));
	}

	@Test
	public void testGetPaymentsNotPaymentsInFile() {
		testPaymentsFile = new File("./resources/nopayments.csv");
		paymentDaoFileImpl = new PaymentDaoFileImpl(testPaymentsFile);
		assertThat(paymentDaoFileImpl.getPayments(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetPaymentsNoPaymentsFile() {
		testPaymentsFile = new File("./resources/notExistentPayments.csv");
		paymentDaoFileImpl = new PaymentDaoFileImpl(testPaymentsFile);
		paymentDaoFileImpl.getPayments(0);
	}
	
	@Test
	public void testAddPayment() throws IOException{		 
		testPaymentsFile = new File("./resources/payments.csv");
		paymentDaoFileImpl = new PaymentDaoFileImpl(testPaymentsFile);
		 
		Payment Payment = new Payment();
		Payment.setId(1);
		Payment.setProjectId(12);
		Payment.setName("Vova");
		Payment.setCardNumber("2342 3434 2342 3424"); 
		Payment.setPledge(30);
		
		FileWriter fileWriter = new FileWriter(testPaymentsFile, false);
		fileWriter.write("");
		
		paymentDaoFileImpl.addPayment(Payment);
	       
		List<Payment> payments = paymentDaoFileImpl.getPayments(12);
		assertThat(payments.get(0).getCardNumber(), is("2342 3434 2342 3424"));
 
	}
	
	@Test
	public void testGetPledged(){
		testPaymentsFile = new File("./resources/payments.csv");
		paymentDaoFileImpl = new PaymentDaoFileImpl(testPaymentsFile);
		assertThat(paymentDaoFileImpl.getPledged(12), is(30));
	}
}
