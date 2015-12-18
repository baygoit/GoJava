package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.dao.AbstractDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;

public class FaqDaoMysqlImpl extends AbstractDao implements FaqDao {

	public void add(Faq faq) {
		String sql = "INSERT INTO faqs (project_id, question) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { faq.getProjectID(), faq.getQuestion() });
	}

	public void remove(Faq faq) {
		String sql = "DELETE FROM faqs WHERE project_id = ?";
		jdbcTemplate.update(sql, new Object[] { faq.getProjectID() });
	}

	public List<Faq> getProjectFaqs(int projectId) {
		String sql = "SELECT project_id, question FROM faqs WHERE project_id = ?";
		return jdbcTemplate.query(sql, new Object[] { projectId }, new FaqRowMapper());
	}

	public class FaqRowMapper implements RowMapper<Faq> {
		@Override
		public Faq mapRow(ResultSet rs, int rowNum) throws SQLException {
			Faq faq = new Faq();
			faq.setProjectID(rs.getInt("project_id"));
			faq.setQuestion(rs.getString("question"));
			return faq;
		}
	}
}
