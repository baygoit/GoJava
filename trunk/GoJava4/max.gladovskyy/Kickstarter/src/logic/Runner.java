package logic;

import java.util.List;

import pages.*;
import UserInterface.Input;
import UserInterface.Output;
import datasource.DataSource;
import entities.*;

public class Runner {
	private Output output;
	private Input input;
	private DataSource dataSource;
	
	public Runner(Output output, Input input, DataSource dataSource) {
		this.output = output;
		this.input = input;
		this.dataSource = dataSource;
	}

	public void run() {
		int[] menuCurrentPosition = new int[2];
		while (true) {
			if (menuCurrentPosition[0] == 0 && menuCurrentPosition[1] == 0) {
			Quote quote = new Quote();
			List<String> categorys = dataSource.getCategorysNames();
			Page mainPage = new MainPage(quote, categorys);
			output.print(mainPage);
			} else if (menuCurrentPosition[1] == 0) {
				String categoryName = dataSource.get
			} else {
				
			}
		}
		
	}

}
