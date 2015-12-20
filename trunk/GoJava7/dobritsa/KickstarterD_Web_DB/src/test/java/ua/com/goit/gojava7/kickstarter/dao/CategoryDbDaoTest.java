package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDbDaoTest {

	@Mock
	private ResultSet resultSet;
	@Mock
	BasicDataSource basicDataSource;
	@InjectMocks
	CategoryDbDao categoryDao;
}
