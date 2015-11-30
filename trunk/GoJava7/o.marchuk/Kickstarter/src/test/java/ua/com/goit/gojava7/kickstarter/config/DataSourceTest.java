package ua.com.goit.gojava7.kickstarter.config;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DataSourceTest {

	@Test
	public void testSupportedDataSourcesCount() {
		assertThat(DataSource.values().length, is(3));
	}

	@Test
	public void testSupportedDataSources() {
		assertThat(DataSource.valueOf("MEMORY"), is(DataSource.MEMORY));
		assertThat(DataSource.valueOf("FILE"), is(DataSource.FILE));
		assertThat(DataSource.valueOf("MYSQL"), is(DataSource.MYSQL));
	}

}
