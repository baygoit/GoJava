package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardDaoPostgreImpl implements AwardDao {

    private static final String SQL_FIND_AWARD_BY_PROJECT =
            "SELECT name, amount, description " +
                    "FROM award " +
                    "where projectid=?";
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Award> getAwardsByProject(Project project) {
        List<Award> awards = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_AWARD_BY_PROJECT)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Award award = new Award();
                award.setAmount(rs.getDouble("amount"));
                award.setName(rs.getString("name"));
                awards.add(award);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return awards;
    }
}
