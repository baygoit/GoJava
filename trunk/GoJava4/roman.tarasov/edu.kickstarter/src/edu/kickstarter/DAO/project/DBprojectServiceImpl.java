package edu.kickstarter.DAO.project;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;

public class DBprojectServiceImpl implements ProjectService {

	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws KickstarterException {
		List<Project> sorted = new ArrayList<Project>();
		Statement statement;
		Dao.getInstance();
		try {
			statement = Dao.getDatabaseService().getConnection()
					.createStatement();
			StringBuffer sql = new StringBuffer();

			sql.append("SELECT ");
			sql.append("id_project, ");
			sql.append("id_category, ");
			sql.append("name, ");
			sql.append("short_description, ");
			sql.append("description, ");
			sql.append("pledged, ");
			sql.append("amount, ");
			sql.append("days_to_go, ");
			sql.append("link, ");
			sql.append("history,");
			sql.append("invest_options ");
			sql.append("FROM projects ");
			sql.append("WHERE id_category=");
			sql.append(Integer.toString(categoryID));

			ResultSet rs = statement.executeQuery(sql.toString());
			while (rs.next()) {
				sorted.add(newProject(rs));
			}

		} catch (SQLException | KickstarterException e) {
			sorted = null;
			throw new KickstarterException(
					"sortProjectsByCategoryID exception", e);
		}
		try {
			Dao.getDatabaseService().closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sorted;
	}

	private Project newProject(ResultSet rs) throws SQLException {
		Project project = new Project();
		project.setID(rs.getInt(1));
		project.setCategoryID(rs.getInt(2));
		project.setName(rs.getString(3));
		project.setShortDescription(rs.getString(4));
		project.setDescription(rs.getString(5));
		project.setPledged(rs.getDouble(6));
		Array amount = rs.getArray(7);
		Double[] a = (Double[]) amount.getArray();
		project.setAmount(a);
		project.setDaysToGo(rs.getInt(8));
		project.setLinkToVideo(rs.getString(9));
		project.setHistory(rs.getString(10));
		Array investOptions = rs.getArray(11);
		String[] str = (String[]) investOptions.getArray();
		project.setInvestmentOptions(str);
		return project;
	}

	@Override
	public Project getProjectById(int ID) throws KickstarterException {
		Dao.getInstance();
		Project project = null;
		;
		Statement statement;
		try {
			statement = Dao.getDatabaseService().getConnection()
					.createStatement();
			StringBuffer sql = new StringBuffer();

			sql.append("SELECT ");
			sql.append("id_project, ");
			sql.append("id_category, ");
			sql.append("name, ");
			sql.append("short_description, ");
			sql.append("description, ");
			sql.append("pledged, ");
			sql.append("amount, ");
			sql.append("days_to_go, ");
			sql.append("link, ");
			sql.append("history, ");
			sql.append("invest_options ");
			sql.append("FROM projects ");
			sql.append("WHERE id_project=");
			sql.append(Integer.toString(ID));

			ResultSet rs = statement.executeQuery(sql.toString());
			rs.next();
			project = newProject(rs);
		} catch (KickstarterException | SQLException e) {
			project = null;
			throw new KickstarterException("getProjectById exception", e);
		}
		try {
			Dao.getDatabaseService().closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}
}
