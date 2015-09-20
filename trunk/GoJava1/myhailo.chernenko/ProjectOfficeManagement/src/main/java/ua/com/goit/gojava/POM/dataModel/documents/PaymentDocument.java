package ua.com.goit.gojava.POM.dataModel.documents;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;

@Entity
@Table(name = "payment_document")
public class PaymentDocument implements FinancialDocument {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_account_id")
	private BankAccount bankAccount;
	
	@Column
	private String description;
	
	@Embedded
	@AttributeOverrides( {
	        @AttributeOverride(name="value", column = @Column(name="sum") ),
	        @AttributeOverride(name="currency", column = @Column(name="currency") )
	    })
    private Money docSum;
	
	@Column
	private boolean checked;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="doc")
    private List<PaymentDocumentDetail> paymentDocumentDetails;
	
	@Override
	public String getDocType() {	
		return this.getClass().getName();
	}
	
	@Override
	public long getId() {	
		return id;	
	}
	
	public void setId(long id) {	
		this.id = id;	
	}
	
	public Date getDate() {		
		return date;	
	}
	
	public void setDate(Date date) {	
		this.date = date;		
	}
	
	public BankAccount getBankAccount() {	
		return bankAccount;	
	}
	
	public void setBankAccount(BankAccount bankAccount) {		
		this.bankAccount = bankAccount;		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Money getDocSum() {
		return (docSum == null)? null : new Money(docSum);
	}
	
	public void setDocSum(Money sum) {
		this.docSum = new Money(sum);
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public void addDocSum(Money sum) throws POMDataModelException {

		if (this.docSum == null) {
			setDocSum(sum);;
		} else {
			this.docSum.add(sum);
		}

	}

	public Currency getCurrency() {
		return (bankAccount == null)? null : bankAccount.getCurrency();
	}

	public List<PaymentDocumentDetail> getPaymentDocumentDetails() {
		return paymentDocumentDetails;
	}

	public void setPaymentDocumentDetails(
			List<PaymentDocumentDetail> paymentDocumentDetails) {
		this.paymentDocumentDetails = paymentDocumentDetails;
		
		for(PaymentDocumentDetail detail: getPaymentDocumentDetails()){
			detail.setDoc(this);
		}
	}

	public PaymentDocumentDetail getPaymentDetailByRowNumber(long rowNumber) {
		
		PaymentDocumentDetail answer = null;
		for(PaymentDocumentDetail detail: getPaymentDocumentDetails()){
			if(detail.getRowNumber() == rowNumber) {
				answer = detail;
				break;
			}
		}
		return answer;
	}

	public PaymentDocumentDetail addNewDetail() {

		PaymentDocumentDetail newDocDetails = new PaymentDocumentDetail();
		if(paymentDocumentDetails == null) {
			paymentDocumentDetails = new ArrayList<PaymentDocumentDetail>();
		}
		paymentDocumentDetails.add(newDocDetails);
		newDocDetails.setRowNumber(paymentDocumentDetails.size());
		newDocDetails.setDoc(this);
		
		return newDocDetails;
	}
	
}
