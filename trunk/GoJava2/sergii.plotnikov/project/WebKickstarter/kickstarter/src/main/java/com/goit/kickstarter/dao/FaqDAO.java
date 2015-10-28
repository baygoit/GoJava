package com.goit.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goit.kickstarter.model.FAQ;

@Component
public class FaqDAO extends AbstractDAO{
	
	@Transactional
	public void addFaq(FAQ faq) {
		getSession().save(faq);
	}
	
	@Transactional
	public List<FAQ> getFaq(int id) {
		Query query = getSession().getNamedQuery("getFaqs");
		query.setInteger("project", id);
		return query.list();
	}
}
