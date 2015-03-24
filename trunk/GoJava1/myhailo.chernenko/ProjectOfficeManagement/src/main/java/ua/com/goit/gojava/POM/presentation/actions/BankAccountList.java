package ua.com.goit.gojava.POM.presentation.actions;

import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CashMovementService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountList extends ActionSupport {

	private static final long serialVersionUID = 6252551373098179983L;
	private static final Logger LOG=Logger.getLogger(BankAccountList.class);
	@Inject
	private BankAccountService bankAccountService;
	@Inject
	private CashMovementService cashMovementService;

	private long editCurrent;
	private long openCashMovement;
	private long dellCurrent;
	private boolean update;
	private boolean undoEdit;
	private boolean addNew;
	
	private Map<String,String> currenciesMap;
	private List<BankAccount> bankAccounts;
	private BankAccount currentAccountForEdit;
	private String name;
	private String bankName;
	private String currencyCode;

	public String execute() throws Exception {
		
		if(editCurrent != 0){
			
			try {
				editCurrent();
			} catch(POMDataModelException e) {
				LOG.error("Can not load Bank Account for edit: "+e.getMessage(),e);
				addActionError("Can not load Bank Account for edit!");
			}
			
		} else if(openCashMovement != 0){
			
			try {
				openCashMovement();
			} catch(POMDataModelException e) {
				LOG.error("Can not open Cash Movement: "+e.getMessage(),e);
				addActionError("Can not open Cash Movement!"); 
			}
			
			return "cashMovementRedirect";
			
		} else if(dellCurrent != 0){
			
			try {
				dellCurrent();
			} catch(POMDataModelException e) {
				LOG.error("Can not delete Bank Account: "+e.getMessage(),e);
				addActionError("Can not delete Bank Account!"); 
			}
			
		} else if(update == true){
			
			try {
				update();
			} catch(POMDataModelException e) {
				LOG.error("Can not save new Bank Account: "+e.getMessage(),e);
				addActionError("Can not save new Bank Account!"); 
			}
			
		} else if(undoEdit == true){
			
			undoEdit();
			
		} else if(addNew == true){
			
			try {
				addNew();
			} catch(POMDataModelException e) {
				LOG.error("Can not create Bank Account: "+e.getMessage(),e);
				addActionError("Can not create Bank Account!"); 
			}
			
		} else {
	
		}
		
		bankAccounts = bankAccountService.retrieveAll();
		currenciesMap = new HashMap<String,String>();
		for(Currency currency: Currency.getAvailableCurrencies()) {
			currenciesMap.put(currency.getCurrencyCode(), currency.getCurrencyCode());
		};
		
		return ActionSupport.SUCCESS;
	}
	
	public void editCurrent() throws POMDataModelException {
		
		currentAccountForEdit = bankAccountService.retrieveById(editCurrent);
		ActionContext.getContext().getSession().put("currentAccountForEdit", currentAccountForEdit);
		
	}
	
	public void openCashMovement() throws POMDataModelException {
		
		BankAccount bankAccount = bankAccountService.retrieveById(openCashMovement);
		ActionContext.getContext().getSession().put("bankAccountFilterValue", bankAccount);
		
	}
	
	private void dellCurrent() throws POMDataModelException {

		bankAccountService.delete(bankAccountService.retrieveById(dellCurrent));
		
	}

	private void update() throws POMDataModelException {

		currentAccountForEdit = (BankAccount) ActionContext.getContext().getSession().get("currentAccountForEdit");
		currentAccountForEdit.setName(name);
		currentAccountForEdit.setBankName(bankName);
		
		if(!currencyCode.isEmpty()) {
			currentAccountForEdit.setCurrency(Currency.getInstance(currencyCode));
		}
		
		bankAccountService.update(currentAccountForEdit);
		
		currentAccountForEdit = null;
		
	}

	private void undoEdit() {

		currentAccountForEdit = null;
	}

	private void addNew() throws POMDataModelException {

		BankAccount bankAccount= new BankAccount();
		bankAccount.setName(name);
		bankAccount.setBankName(bankName);
		
		if(!currencyCode.isEmpty()) {
			bankAccount.setCurrency(Currency.getInstance(currencyCode));
		}
		bankAccountService.create(bankAccount);
		
	}

	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	public CashMovementService getCashMovementService() {
		return cashMovementService;
	}
	public void setCashMovementService(CashMovementService cashMovementService) {
		this.cashMovementService = cashMovementService;
	}
	public long getDellCurrent() {
		return dellCurrent;
	}
	public void setDellCurrent(long dellCurrent) {
		this.dellCurrent = dellCurrent;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isUndoEdit() {
		return this.undoEdit;
	}
	public void setUndoEdit(boolean undoEdit) {
		this.undoEdit = undoEdit;
	}
	public boolean isAddNew() {
		return this.addNew;
	}
	public void setAddNew(boolean addNew) {
		this.addNew = addNew;
	}
	public long getEditCurrent() {
		return editCurrent;
	}
	public void setEditCurrent(long editCurrent) {
		this.editCurrent = editCurrent;
	}
	public long getOpenCashMovement() {
		return openCashMovement;
	}
	public void setOpenCashMovement(long openCashMovement) {
		this.openCashMovement = openCashMovement;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public BankAccount getCurrentAccountForEdit() {
		return currentAccountForEdit;
	}

	public void setCurrentAccountForEdit(BankAccount currentAccountForEdit) {
		this.currentAccountForEdit = currentAccountForEdit;
	}

	public Map<String, String> getCurrenciesMap() {
		return currenciesMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
