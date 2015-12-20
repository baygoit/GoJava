package ua.com.goit.gojava7.kickstarter.dao.jdbc.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

public abstract class StatementSetter<T> implements BatchPreparedStatementSetter {

	List<T> list;

/*	public StatementSetter(List<T> list) {
		this.list = list;
	}*/

/*	public StatementSetter(T element) {
		list = new ArrayList<>();
		list.add(element);
	}*/
	
	@SuppressWarnings("unchecked")
	public StatementSetter(Object argument) {
		if (argument instanceof List) {
			list = (List<T>) argument;
		} else {
			list = new ArrayList<>();
			list.add((T) argument);
		}
	}

	@Override
	public void setValues(PreparedStatement statement, int i) throws SQLException {
		setupStatement(statement, list.get(i));
	}
	
	public abstract void setupStatement(PreparedStatement statement, T element) throws SQLException ;

	@Override
	public int getBatchSize() {
		return list.size();
	}
}

