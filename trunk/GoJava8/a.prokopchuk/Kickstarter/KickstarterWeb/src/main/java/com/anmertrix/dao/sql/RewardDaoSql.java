package com.anmertrix.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Reward;

@Repository
public class RewardDaoSql implements RewardDao {

	private static final String SELECT_REWARDS = "SELECT id, name, amount, description FROM reward";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Reward> getRewards() {
		return jdbcTemplate.query(SELECT_REWARDS, new BeanPropertyRowMapper<Reward>(Reward.class));
	}

}
