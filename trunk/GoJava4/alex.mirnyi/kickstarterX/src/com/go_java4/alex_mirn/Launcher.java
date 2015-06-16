package com.go_java4.alex_mirn;

import java.sql.*;
import java.io.IOException;
import java.util.Random;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.dao.DaoImpl;
import com.go_java4.alex_mirn.view.io.ConsoleIO;
import com.go_java4.alex_mirn.view.pages.PageDispatcher;



public class Launcher {
	
	public static void main(String[] args) {
		try {
			Dao repository = new DaoImpl(new Random());

			PageDispatcher pageDispatcher = new PageDispatcher(new ConsoleIO(), repository);
			while (true) {
				pageDispatcher.run();
			}
		} catch (SQLException | NullPointerException | IOException e) {
			e.printStackTrace();
		}
	}
}