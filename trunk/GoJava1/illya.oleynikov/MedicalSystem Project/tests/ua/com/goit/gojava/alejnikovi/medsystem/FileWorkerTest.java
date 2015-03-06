package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.alejnikovi.medsystem.dao.PlainFileDAO;

public class FileWorkerTest {
	
	private String fileName = "TestFile.csv";
	private static List<Persistable> listToWrite = new ArrayList<Persistable>();
	
	@BeforeClass
	public static void setTestList() {
		listToWrite.add(new Specialization("1"));
		listToWrite.add(new Specialization("2"));
		listToWrite.add(new Specialization("3"));
	}
	
	@Before
	public void clearFile() throws IOException {
		PlainFileDAO.clearFile(fileName);
	}
	
	@Test
	public void testWriteToFile() throws IOException {
		PlainFileDAO.writeToFile(fileName, "test value to write");
		List<String> valuesFromFile = PlainFileDAO.readFromFile(fileName);
		assertEquals("test value to write",valuesFromFile.get(0));
	}

	@Test
	public void testUpdateFile() throws IOException {
		PlainFileDAO.writeToFile(fileName, listToWrite);
		Specialization testSpec = new Specialization(); 
		testSpec = (Specialization)listToWrite.get(0);
		testSpec.setName("New specialisation");
		PlainFileDAO.updateFile(fileName, listToWrite);
		List<String> valuesFromFile = PlainFileDAO.readFromFile(fileName);
		assertEquals("New specialisation",valuesFromFile.get(0));
	}



}
