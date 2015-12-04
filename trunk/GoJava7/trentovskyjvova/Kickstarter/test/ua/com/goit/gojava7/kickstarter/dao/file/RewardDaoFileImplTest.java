package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class RewardDaoFileImplTest {
	private File testRewardsFile;
	private RewardDaoFileImpl rewardDaoFileImpl;

	@Test
	public void testGetRewards() {
		testRewardsFile = new File("./resources/rewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		assertThat(rewardDaoFileImpl.getRewards(1).size(), is(3));
	}

	@Test
	public void testGetRewardsNotRewardsInFile() {
		testRewardsFile = new File("./resources/norewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		assertThat(rewardDaoFileImpl.getRewards(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetRewardsNoRewardsFile() {
		testRewardsFile = new File("./resources/notExistentRewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		rewardDaoFileImpl.getRewards(0);
	}

	@Test
	public void testGetReward() {
		testRewardsFile = new File("./resources/rewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		assertThat(rewardDaoFileImpl.getReward(2, 1).getBenefit(),
				is("a middle one"));
	}

	@Test
	public void testSize() {
		testRewardsFile = new File("./resources/rewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		assertThat(rewardDaoFileImpl.size(1), is(3));
	}
	
	@Test
	public void testGetRewardById() {
		testRewardsFile = new File("./resources/rewards.csv");
		rewardDaoFileImpl = new RewardDaoFileImpl(testRewardsFile);
		assertThat(rewardDaoFileImpl.getReward(2).getId(),
				is(2));
	}
}
