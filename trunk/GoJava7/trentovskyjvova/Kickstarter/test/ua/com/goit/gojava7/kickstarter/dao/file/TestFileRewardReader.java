package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class TestFileRewardReader {
	private File testRewardsFile;
	private FileRewardReader fileRewardReader;

	@Test
	public void testGetRewards() {
		testRewardsFile = new File("./resources/rewards.csv");
		fileRewardReader = new FileRewardReader(testRewardsFile);
		assertThat(fileRewardReader.getRewards(1).size(), is(3));
	}

	@Test
	public void testGetRewardsNotRewardsInFile() {
		testRewardsFile = new File("./resources/norewards.csv");
		fileRewardReader = new FileRewardReader(testRewardsFile);
		assertThat(fileRewardReader.getRewards(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetRewardsNoRewardsFile() {
		testRewardsFile = new File("./resources/notExistentRewards.csv");
		fileRewardReader = new FileRewardReader(testRewardsFile);
		fileRewardReader.getRewards(0);
	}

	@Test
	public void testGetReward() {
		testRewardsFile = new File("./resources/rewards.csv");
		fileRewardReader = new FileRewardReader(testRewardsFile);
		assertThat(fileRewardReader.getReward(2).getBenefit(),
				is("a middle one"));
	}

	@Test
	public void testSize() {
		testRewardsFile = new File("./resources/rewards.csv");
		fileRewardReader = new FileRewardReader(testRewardsFile);
		assertThat(fileRewardReader.size(), is(4));
	}
	
}
