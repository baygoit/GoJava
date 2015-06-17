package dao.project;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.pool.KickstarterException;


public class DBprojectServiceImpl implements ProjectService {
	Connection conn;
	public DBprojectServiceImpl(Connection conn) {
		this.conn=conn;
	}

	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws KickstarterException {
		List<Project> sorted = new ArrayList<Project>();
		Statement statement;
		try {
			statement = conn.createStatement();
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

			if (!rs.next()) {
				throw new KickstarterException("the category was not found");
			}
			do {
				sorted.add(newProject(rs));
			} while (rs.next());

		} catch (SQLException | KickstarterException e) {
			sorted = null;

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (sorted == null) {
				throw new KickstarterException(
						"the category or projects was not found");
			}
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
		Project project = null;
		Statement statement;
		try {
			statement = conn.createStatement();
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
		} catch (SQLException e) {
			project = null;

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (project == null) {
				throw new KickstarterException("the project was not found");
			}
		}
		return project;
	}
}
