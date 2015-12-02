package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class RewardDaoFileImpl implements RewardDao {
	private static final String CSV_SPLIT_BY = ";";
	private File reswardsFile;
	
	public RewardDaoFileImpl(File reswardsFile) {
		this.reswardsFile = reswardsFile;
	}

	@Override
	public List<Reward> getRewards(int projectId) {
		List<Reward> rewards = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream reswardsFileSteam = new FileInputStream(reswardsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					reswardsFileSteam));

			String line = null;
			int id = 0;
			int pledge = 0;
			String benefit = null;
			while (null != (line = fileReader.readLine())) {
				String[] rewardLine = line.split(CSV_SPLIT_BY);
				if (rewardLine.length < 4) {
					throw new WrongFileFormatException("Wrong reswards.csv format.");
				} else if (rewardLine[0] == "") {
					throw new WrongFileFormatException(
							"Wrong reswards.csv format. Cannot find id");
				} else if (rewardLine[1] == "") {
					throw new WrongFileFormatException(
							"Wrong reswards.csv format. Cannot find project id");
				} else if (rewardLine[2] == "") {
					throw new WrongFileFormatException(
							"Wrong reswards.csv format. Cannot find pledge of resward");
				} else if (rewardLine[3] == "") {
					throw new WrongFileFormatException(
							"Wrong reswards.csv format. Cannot find benefit of resward");
				}
				if (projectId != 0
						&& projectId != Integer.parseInt(rewardLine[1])) {
					continue;
				}
				id = Integer.parseInt(rewardLine[0]);
				pledge = Integer.parseInt(rewardLine[2]);
				benefit = rewardLine[3];
				
				Reward reward = new Reward(id, projectId);
				reward.setPledge(pledge);
				reward.setBenefit(benefit);
				rewards.add(reward);
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + reswardsFile);
				}
			}
		}

		return rewards;
	}

	@Override
	public Reward getReward(int userChoise, int projectId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Reward> reward = getRewards(projectId);
			return reward.get(userChoise - 1);
		}
	}

	@Override
	public int size(int projectId) {
		return getRewards(projectId).size();
	}

}
