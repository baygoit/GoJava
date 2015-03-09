package ua.com.goit.gojava2.solo307.interview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class InterviewDAO extends AbstractDAO {

	public void writeName(String name) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "INSERT INTO interviews(applicant_name) VALUES ('" + name
				+ "')";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
	}

	public void writeTime(long start) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "UPDATE interviews SET start_time=" + start
				+ "WHERE id=(SELECT MAX(id) FROM interviews)";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
	}

	public long readStartTime() throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "SELECT start_time FROM interviews WHERE id=(SELECT MAX(id) FROM interviews)";
		ResultSet startTime = null;
		long start = 0;
		try {
			startTime = statement.executeQuery(sql);
			while (startTime.next()) {
				start = startTime.getLong("start_time");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
		return start;
	}

	public void persistMarks(StatisticsDTO dto)
			throws InterviewSimulatorException {
		int correct = dto.correct;
		int halfCorrect = dto.halfCorrect;
		int incorrect = dto.incorrect;
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "UPDATE interviews SET correct=" + correct
				+ ", half_correct=" + halfCorrect + ", incorrect=" + incorrect
				+ "WHERE id=(SELECT MAX(id) FROM interviews)";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
	}

	public void writeDuration(String time) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "UPDATE interviews SET duration='" + time
				+ "'WHERE id=(SELECT MAX(id) FROM interviews)";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
	}

	public void persistDate(String date) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = makeConnection();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		String sql = "UPDATE interviews SET date='" + date
				+ "'WHERE id=(SELECT MAX(id) FROM interviews)";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"Performing add name query was failed:-(");
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InterviewSimulatorException(
						"closing con was failed:-(");
			}
		}
	}
}
