package ua.com.goit.gojava.POM.dataModel.cash;

import java.util.Currency;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;

@Entity
@Table(name = "cash_movement")
public class CashMovementEntry {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_account_id")
	private BankAccount bankAccount;
	
	@Embedded
	@AttributeOverrides( {
	        @AttributeOverride(name="value", column = @Column(name="sum") ),
	        @AttributeOverride(name="currency", column = @Column(name="currency") )
	    })
    private Money sum = new Money();
	
	@Any(metaColumn = @Column(name = "doc_type"))
    @AnyMetaDef(idType = "long", metaType = "string", 
            metaValues = { 
            @MetaValue(targetEntity = PaymentDocument.class, value = "PaymentDocument"),
       })
	@JoinColumn(name="doc_id")
    private FinancialDocument doc;
	
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
	
	public Money getSum() {
		
		return sum;
		
	}
	
	public void setSum(Money sum) {
		
		this.sum = sum;
		
	}

	public BankAccount getBankAccount() {
		
		return bankAccount;
		
	}

	public void setBankAccount(BankAccount bankAccount) {
		
		this.bankAccount = bankAccount;
		
	}
	
	public Currency getCurrency() {
		
		Currency currency = null;
		if(bankAccount != null) {
			currency = bankAccount.getCurrency();
		}
		return currency;
		
	}

	public void setDoc(FinancialDocument doc) {
		this.doc = doc;
	}

	public FinancialDocument getDoc() {
		return this.doc;
	}
}
