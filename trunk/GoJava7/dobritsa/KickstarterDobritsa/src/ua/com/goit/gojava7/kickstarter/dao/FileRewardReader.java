package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class FileRewardReader extends FileReader<Reward>{

	public FileRewardReader(File file) {
		super(file);
	}
	
	@Override
	public List<Reward> readIt() throws IOException {
		String amount;
		while ((amount = (fileReader.readLine())) != null) {
			Reward reward = new Reward();
			reward.setAmount(new Integer(amount));
			reward.setReward(fileReader.readLine());			
			data.add(reward);
		}
		return data;
	}
}
