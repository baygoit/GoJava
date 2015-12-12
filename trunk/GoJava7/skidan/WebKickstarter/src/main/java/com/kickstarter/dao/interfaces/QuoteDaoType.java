package com.kickstarter.dao.interfaces;

import com.kickstarter.model.Quote;

public abstract class QuoteDaoType {

	protected QuoteDaoInterface quoteDaoInterface;

	public Quote get() {
		return quoteDaoInterface.get();
	}
	public void setType(QuoteDaoInterface quoteDaoInterface) {
		this.quoteDaoInterface = quoteDaoInterface;
	}
}
