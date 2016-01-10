package ua.com.goit.gojava7.kickstarter.dao.db;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentDatabaseDao{
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(PaymentDatabaseDao.class);

    private static String                                table  = "payments";
    private static String                                fields = "id,cardOwner,cardNumber,projectId,amount";

}
