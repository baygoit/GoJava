package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardReader;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.exception.RewardReadException;

public class FileRewardReader implements RewardReader {
	private static final String CSV_SPLIT_BY = ";";
	private File reswardsFile;

	public FileRewardReader(File reswardsFile) {
		this.reswardsFile = reswardsFile;
	}

	@Override
	public List<Reward> readRewards() {
		List<Reward> rewards = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream reswardsFileSteam = new FileInputStream(reswardsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					reswardsFileSteam));

			String line = null;
			int projectId = 0;
			int pledge = 0;
			String benefit = null;
			while (null != (line = fileReader.readLine())) {
				String[] rewardLine = line.split(CSV_SPLIT_BY);
				if (rewardLine.length < 3) {
					throw new RewardReadException("Wrong reswards.csv format.");
				} else if (rewardLine[0] == "") {
					throw new RewardReadException(
							"Wrong reswards.csv format. Cannot find project id");
				} else if (rewardLine[1] == "") {
					throw new RewardReadException(
							"Wrong reswards.csv format. Cannot find pledge of resward");
				} else if (rewardLine[2] == "") {
					throw new RewardReadException(
							"Wrong reswards.csv format. Cannot find benefit of resward");
				}
				projectId = Integer.parseInt(rewardLine[0]);
				pledge = Integer.parseInt(rewardLine[1]);
				benefit = rewardLine[2];
				
				Reward reward = new Reward(projectId);
				reward.setPledge(pledge);
				reward.setBenefit(benefit);
				rewards.add(reward);
			}
		} catch (IOException e) {
			throw new RewardReadException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + reswardsFile);
				}
			}
		}

		if (rewards.isEmpty()) {
			throw new RewardReadException("There is not rewards in file");
		}

		return rewards;
	}

}
