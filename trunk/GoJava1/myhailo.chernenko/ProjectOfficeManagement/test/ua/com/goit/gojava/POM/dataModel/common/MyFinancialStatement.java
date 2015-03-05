package ua.com.goit.gojava.POM.dataModel.common;

import ua.com.goit.gojava.POM.dataModel.temporaryUnusedClases.FinancialStatement;
import ua.com.goit.gojava.POM.persistence.fileDB.DataManager;

public class MyFinancialStatement extends FinancialStatement<MyFinancialEntry>{

	private static final long serialVersionUID = 3186316032061760202L;
	private DataManager dataManager;
	private static final String TEST_DATA_FILE = "C:\\workspace\\ProjectOfficeManagementTEST.dat";
	
	public MyFinancialStatement() {
		super(MyFinancialEntry.class);
		
		dataManager = new DataManager() {
				
				@SuppressWarnings("unused")
				private String dataFile = "";
				public void initialize() {
					dataFile = TEST_DATA_FILE;
				}
				
			};
			
		dataManager.initialize();
		dataManager.readData();
		
	}

	@Override
	public FinancialStatement<MyFinancialEntry> getNewInstanse() {
		
		return new MyFinancialStatement();
	}

	@Override
	public DataManager getDataManager() {
		return dataManager;
	}
	
}
