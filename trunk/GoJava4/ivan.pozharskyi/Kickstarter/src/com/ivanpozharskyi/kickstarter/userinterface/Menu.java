package com.ivanpozharskyi.kickstarter.userinterface;

import java.sql.SQLException;

public interface Menu {
	void show() throws SQLException;

	void setChoise(Object choice);

}
