package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import ua.com.goit.gojava7.kickstarter.dao.db.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;

@Transactional
@Controller
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaymentDao paymentDao;

    
  
    
}
