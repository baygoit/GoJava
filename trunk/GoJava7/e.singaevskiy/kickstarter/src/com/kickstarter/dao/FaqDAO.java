package com.kickstarter.dao;

import com.kickstarter.beans.FAQ;

public class FaqDAO extends CommonDAO<FAQ>{
	
	public FaqDAO() {
		dataSource.add(new FAQ("What's the problem?", "No problem!"));
		dataSource.add(new FAQ("Who is to blame?", "Alexander Herzen"));
		dataSource.add(new FAQ("What to do?", "Do a barrel roll"));
	}
	
}
