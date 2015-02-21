package ua.com.goit.gojava.POM.dataModel.common;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFinancialStatement {

	private class FinancialEntryRealisation extends FinancialEntry{

		private static final long serialVersionUID = -5119463255302552385L;
		
	}
	
	private class FinancialStatementRealisation extends FinancialStatement<FinancialEntryRealisation>{

		public FinancialStatementRealisation() {
			super(FinancialEntryRealisation.class);
		}

		private static final long serialVersionUID = 3186316032061760202L;

		@Override
		public FinancialStatement<FinancialEntryRealisation> getNewInstanse() {
			
			return new FinancialStatementRealisation();
		}
		
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFinancialStatement() {

		assertNotNull(new FinancialStatementRealisation());

	}

	@Test
	public void testGetNewInstanse() {

		/*
		FinancialStatementRealisation newInstance = new FinancialStatementRealisation();
		assertNotNull(newInstance.getNewEntryInstance());
		assertNotEquals(newInstance.getNewEntryInstance(), newInstance);
		*/
	}

	@Test
	public void testGetNewEntryInstance() {

		/*
		FinancialStatementRealisation newInstance = new FinancialStatementRealisation();
		assertNotNull(newInstance.getNewEntryInstance());
		
		new FinancialStatement<FinancialEntry>(FinancialEntry.class) {
			
			private static final long serialVersionUID = 3186316032061760202L;

			@Override
			public FinancialStatement<FinancialEntry> getNewInstanse() {
				return null;
			}
		};
		
		fail("Here must be runtime exception... (Attempt to create Statement for abstract Entries )");
		*/
	}

	@Test
	public void testGetEntries() {
		//TODO fail("Not yet implemented");
	}

	@Test
	public void testAddEntry() {
		//TODO fail("Not yet implemented");
	}

	@Test
	public void testDeleteDocEntries() {
		//TODO fail("Not yet implemented");
	}

	@Test
	public void testGetTotal() {
		//TODO fail("Not yet implemented");
	}

	@Test
	public void testGetRolledUp() {
		//TODO fail("Not yet implemented");
	}

	@Test
	public void testGetDifference() {
		//TODO fail("Not yet implemented");
	}

}
