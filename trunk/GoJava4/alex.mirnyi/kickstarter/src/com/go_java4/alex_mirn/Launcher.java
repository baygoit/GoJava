package com.go_java4.alex_mirn;

import java.io.IOException;
import java.util.Random;

import com.go_java4.alex_mirn.data_containers.FileRepository;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.data_containers.TestRepository;
import com.go_java4.alex_mirn.input_output.io.ConsoleIO;
import com.go_java4.alex_mirn.input_output.pages.PageDispatcher;



public class Launcher {
	public static void main(String[] args) throws IOException {	
		Repository repository = new FileRepository(new Random());
//		Repository repository = new TestRepository(new Random());
		PageDispatcher pageDispatcher = new PageDispatcher(new ConsoleIO(), repository);
		while (true) {
			pageDispatcher.run();
		}
	}

}
