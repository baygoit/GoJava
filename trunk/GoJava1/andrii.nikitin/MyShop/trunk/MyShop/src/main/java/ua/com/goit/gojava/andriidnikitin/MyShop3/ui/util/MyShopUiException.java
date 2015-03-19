package ua.com.goit.gojava.andriidnikitin.MyShop3.ui.util;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop3.commons.ErrorLogger;




public class MyShopUiException {

	private static Logger log = Logger.getLogger("MyShop.GUI");
	
	static void logException(Exception e){
		ErrorLogger.logException(e, log);
	}
}
