package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileReader extends FileReader<Reward> {

	public RewardFileReader(File file) {
		super(file);
	}

	@Override
	public List<Reward> readFromFile(BufferedReader bufferedReader) throws IOException {
		String projectName;
		String amount;
		while ((projectName = (bufferedReader.readLine())) != null) {
			while ((amount = (bufferedReader.readLine())) != null) {
				if (amount.equals(""))
					break;
				String text = bufferedReader.readLine();
				Reward reward = new Reward(new Integer(amount), text);
				reward.setProjectName(projectName);
				data.add(reward);

			}
		}
		return data;
	}
}
