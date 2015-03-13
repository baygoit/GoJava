package ua.com.goit.gojava.andriidnikitin.servlets;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.util.ErrorLogger;



public class MyShopGUIException {

	private static Logger log = Logger.getLogger("MyShop.GUI");
	
	static void logException(Exception e){
		ErrorLogger.logException(e, log);
	}
}
