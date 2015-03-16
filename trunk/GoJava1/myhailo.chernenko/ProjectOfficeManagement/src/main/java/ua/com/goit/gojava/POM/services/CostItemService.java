package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.postgresDB.CostItemDAO;

public class CostItemService {
	
	CostItemDAO costItemDAO;

	public void setCostItemDAO(CostItemDAO costItemDAO) {
		
		this.costItemDAO = costItemDAO;
		
	}
	
	public List<CostItem> retrieveAll() throws POMDataModelException {
		
		return costItemDAO.retrieveAll();
		
	}

	public CostItem retrieveById(long id) throws POMDataModelException {

		return costItemDAO.retrieveById(id);
		
	}

	public void delete(CostItem bankAccount) throws POMDataModelException {

		costItemDAO.delete(bankAccount);
		
	}

	public void create(CostItem bankAccount) throws POMDataModelException {

		costItemDAO.create(bankAccount);
		
	}

	public void update(CostItem bankAccount) throws POMDataModelException {

		costItemDAO.update(bankAccount);
		
	}

}
