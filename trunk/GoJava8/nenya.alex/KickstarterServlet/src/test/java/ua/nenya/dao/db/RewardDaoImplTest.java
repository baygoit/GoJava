package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.domain.Reward;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(locations="classpath*:/aplicationContextTest.xml"),
	  @ContextConfiguration(locations="classpath*:/RewardTest.hbm.xml")
	})
public class RewardDaoImplTest {

	private static EmbeddedDatabase db;
	private RewardDaoImpl rewardDaoImpl = new RewardDaoImpl();

	private static List<Reward> rewards = new ArrayList<>();

	@BeforeClass
	public static void setUp() {
		initRewards();
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/insertReward.sql")
	    		.build();
	}


	@AfterClass
	public static void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deleteReward.sql")
	    		.build();
	}
	@Test
	public void testGetRewards() {
		Collections.sort(rewards, new Comparator<Reward>() {
			@Override
			public int compare(Reward o1, Reward o2) {
				return o1.getId()-o2.getId();
			}
		});
		
		List<Reward> testRewards = rewardDaoImpl.getRewards(1);
		assertNotNull(testRewards);
		assertThat(rewards, is(testRewards));
	}


	private static void initRewards() {
		Reward reward100 = new Reward();
		reward100.setId(1);
		reward100.setProjectId(1);
		reward100.setAmount(100);
		reward100.setName("100$");
		reward100.setDescription("Reward100");
		
		Reward reward200 = new Reward();
		reward200.setId(2);
		reward200.setProjectId(1);
		reward200.setAmount(200);
		reward200.setName("200$");
		reward200.setDescription("Reward200");
		
		rewards.add(reward100);
		rewards.add(reward200);
	}
}
