package ua.com.goit.gojava.andriidnikitin.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLAdapterTest {
	
	@Test
	public void marshallingTest() {
		try{
			new StorageXmlNew();
		} catch(java.lang.ExceptionInInitializerError e){
			e.printStackTrace(System.out);
			fail();
		}
		
	}
	
}