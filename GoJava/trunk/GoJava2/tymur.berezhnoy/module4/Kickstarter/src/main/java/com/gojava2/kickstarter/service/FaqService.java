package com.gojava2.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gojava2.kickstarter.entity.FAQ;
import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.FaqRepository;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void save(FAQ faq, String name) {
		User user = userRepository.findByName(name);
		faq.setUser(user);
		faqRepository.save(faq);
	}
}