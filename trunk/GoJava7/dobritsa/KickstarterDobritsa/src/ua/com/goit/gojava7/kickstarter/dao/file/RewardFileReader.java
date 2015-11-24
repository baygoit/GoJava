package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileReader extends FileReader<Reward>{

	public RewardFileReader(File file) {
		super(file);
	}
	
	@Override
	public List<Reward> readFromFile(BufferedReader bufferedReader) throws IOException {
		String amount;
		while ((amount = (bufferedReader.readLine())) != null) {		
			Reward reward = new Reward(new Integer(amount), bufferedReader.readLine());
			data.add(reward);
		}
		return data;
	}
}
