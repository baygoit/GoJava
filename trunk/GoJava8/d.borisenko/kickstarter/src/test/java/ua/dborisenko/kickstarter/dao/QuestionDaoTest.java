package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.dborisenko.kickstarter.dao.QuestionDao.QuestionRowMapper;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks 
    private QuestionDao questionDao;
    
    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(111);
        when(rs.getString("request")).thenReturn("testrequest");
        QuestionRowMapper mapper = questionDao.new QuestionRowMapper();
        Question question = mapper.mapRow(rs, 1);
        assertThat(question.getId(), is(111));
        assertThat(question.getRequest(), is("testrequest"));
    }
    
    @Test
    public void getAllForProjectTest() {
        Project project = new Project();
        project.setId(1);
        questionDao.getAllForProject(project);
        verify(jdbcTemplate).query(eq(QuestionDao.GET_BY_PROJECT_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(QuestionRowMapper.class));
    }
    
    @Test
    public void addTest() {
        Question question = new Question();
        question.setId(1);
        question.setRequest("testrequest");
        questionDao.add(1, question);
        verify(jdbcTemplate).update(QuestionDao.ADD_QUERY, 1, question.getRequest());
    }
}
