package ua.com.goit.gojava.andriidnikitin.servlets;

import ua.com.goit.gojava.andriidnikitin.service.util.FileWorker;

public class MyShopGUIException {
	static void logException(Exception e){
		FileWorker.write("errlog.txt", e.getMessage());
	}
}
